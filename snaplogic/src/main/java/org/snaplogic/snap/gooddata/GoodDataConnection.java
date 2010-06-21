package org.snaplogic.snap.gooddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.snaplogic.cc.Capabilities;
import org.snaplogic.cc.Capability;
import org.snaplogic.cc.ComponentAPI;
import org.snaplogic.cc.InputView;
import org.snaplogic.cc.OutputView;
import org.snaplogic.cc.prop.SimpleProp;
import org.snaplogic.cc.prop.SimpleProp.SimplePropType;
import org.snaplogic.common.ComponentResourceErr;
import org.snaplogic.common.exceptions.SnapComponentException;
import org.snaplogic.snapi.PropertyConstraint;
import org.snaplogic.snapi.ResDef;
import org.snaplogic.snapi.PropertyConstraint.Type;

import com.gooddata.exception.GdcLoginException;
import com.gooddata.integration.ftp.GdcFTPApiWrapper;
import com.gooddata.integration.rest.GdcRESTApiWrapper;
import com.gooddata.integration.rest.configuration.NamePasswordConfiguration;

/**
 * Abstract class from which other DB connection components derive. It is used
 * to encapsulate common functionality.
 *
 * @author grisha
 */
public class GoodDataConnection extends ComponentAPI {

    @Override
    public String getDescription() {
        return getLabel() + ". Non-executable component that holds information about a GoodData connection.";
    }


    @Override
    public String getLabel() {
        return "GoodData Connection (Java)";
    }

    @Override
    public String getAPIVersion() {
        return "1.0";
    }

    @Override
    public String getComponentVersion() {
        return "1.0";
    }


    // public static final String PROP_HOST = "host";
    public static final String PROP_USERNAME = "username";
    public static final String PROP_PASSWORD = "password";
    public static final String PROP_PROTOCOL = "protocol";
    public static final String PROP_HOSTNAME = "hostname";
    public static final String PROP_HOSTNAME_FTP = "ftp-hostname";

    @Override
    public Capabilities getCapabilities() {
        // Using a TreeMap ensures keys are ordered, which is good for
        // readability.
        return new Capabilities() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 7753750032102369960L;

			{
                put(Capability.INPUT_VIEW_LOWER_LIMIT, 0);
                put(Capability.INPUT_VIEW_UPPER_LIMIT, 0);
                put(Capability.INPUT_VIEW_ALLOW_BINARY, false);
                put(Capability.OUTPUT_VIEW_LOWER_LIMIT, 0);
                put(Capability.OUTPUT_VIEW_UPPER_LIMIT, 0);
                put(Capability.OUTPUT_VIEW_ALLOW_BINARY, false);
                put(Capability.ALLOW_PASS_THROUGH, false);
            }
        };
    }

    private static List<String> _CONNECTION_CATEGORIES = new ArrayList<String>();

    static {
        _CONNECTION_CATEGORIES.add("connection.gooddata");
    }

    public static List<String> CONNECTION_CATEGORIES = Collections.unmodifiableList(_CONNECTION_CATEGORIES);

    @Override
    public void createResourceTemplate() {

        setPropertyDef(PROP_USERNAME, new SimpleProp("Login", SimplePropType.SnapString, "Username", true));
        
        PropertyConstraint passwdConstraint = new PropertyConstraint(Type.OBFUSCATE, 0);
        SimpleProp passwdProp = new SimpleProp("Password", SimplePropType.SnapString, "Password", passwdConstraint,
                true);
        setPropertyDef(PROP_PASSWORD, passwdProp);
        
        PropertyConstraint protocolConstraint = new PropertyConstraint(Type.LOV, new String[] {"http","https"});   
        setPropertyDef(PROP_PROTOCOL, new SimpleProp("Protocol", 
                SimplePropType.SnapString, 
                "Connection Protocol", 
                protocolConstraint, 
                true));
        setPropertyValue(PROP_PROTOCOL, "https");
        
        setPropertyDef(PROP_HOSTNAME, new SimpleProp("Hostname", SimplePropType.SnapString, "Hostname of GoodData server", true));
        setPropertyValue(PROP_HOSTNAME, "secure.gooddata.com");
        
        setPropertyDef(PROP_HOSTNAME_FTP, new SimpleProp("FTP host", SimplePropType.SnapString, "FTP server where to upload the data", true));
        setPropertyValue(PROP_HOSTNAME_FTP, "secure-upload.gooddata.com");
        
        setCategories(CONNECTION_CATEGORIES, false);
    }

    /**
     * Attempt to connect to the database with current properties. If current
     * properties are not parameterized and connection cannot be made, then an
     * error is set.
     *
     *
     */
    @Override
    public void validate(ComponentResourceErr err) {
        ResDef resdef = this.getResdef();
        for (String propName : resdef.listPropertyNames()) {
            Object propVal = getPropertyValue(propName);
            if (hasParam(propVal)) {
                return;
            }
        }
        try {
            login(resdef);
        } catch (Exception e) {
            String msg = "Connection error: " + e.getMessage();
            err.setMessage(msg);
            elog(e);
        }
    }

    @Override
    public void execute(Map<String, InputView> inputViews, Map<String, OutputView> outputViews) {

    }

    public static GdcRESTApiWrapper login(ResDef goodDataCon) throws GdcLoginException {
        return login(goodDataCon, null);
    }

    public static GdcRESTApiWrapper login(ResDef goodDataCon, ComponentAPI comp) throws GdcLoginException {
        if (!goodDataCon.getComponentName().equals(GoodDataConnection.class.getName())) {
            throw new SnapComponentException("Incorrect ResDef for this operation: " + goodDataCon.getComponentName());
        }

        String username = (String) goodDataCon.getPropertyValue(PROP_USERNAME);
        String passwd = (String) goodDataCon.getPropertyValue(PROP_PASSWORD);
        String protocol = (String) goodDataCon.getPropertyValue(PROP_PROTOCOL);
        String hostname = (String) goodDataCon.getPropertyValue(PROP_HOSTNAME);
        if (comp != null) {
            comp.debug("Logging in as %s", username);
        }
        NamePasswordConfiguration config = new NamePasswordConfiguration(protocol, hostname, username, passwd);
        GdcRESTApiWrapper restApi = new GdcRESTApiWrapper(config);
        restApi.login();
        if (comp != null) {
            comp.debug("Logged in, token: %s", restApi.getToken());
        }

        return restApi;
    }
    
    public static GdcFTPApiWrapper getFtpWrapper(ResDef goodDataCon, ComponentAPI comp) throws GdcLoginException {
        if (!goodDataCon.getComponentName().equals(GoodDataConnection.class.getName())) {
            throw new SnapComponentException("Incorrect ResDef for this operation: " + goodDataCon.getComponentName());
        }

        String username = (String) goodDataCon.getPropertyValue(PROP_USERNAME);
        String passwd = (String) goodDataCon.getPropertyValue(PROP_PASSWORD);
        String protocol = (String) goodDataCon.getPropertyValue(PROP_PROTOCOL);
        String hostname = (String) goodDataCon.getPropertyValue(PROP_HOSTNAME_FTP);
        if (comp != null) {
            comp.debug("Logging in as %s", username);
        }
        NamePasswordConfiguration config = new NamePasswordConfiguration(protocol, hostname, username, passwd);
        GdcFTPApiWrapper restApi = new GdcFTPApiWrapper(config);
        if (comp != null) {
            comp.debug("FTP API instantiated for %s", username);
        }
        
        return restApi;
    }
    
    
}