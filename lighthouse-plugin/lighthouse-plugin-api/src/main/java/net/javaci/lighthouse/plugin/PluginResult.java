package net.javaci.lighthouse.plugin;

import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class PluginResult {

    private String message;
    private String description;
    private HashMap<String, Object> values = new HashMap<String, Object>();
    private String warningMessage;
    private String errorMessage;
    private PluginResultType resultType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Object> getValues() {
        return values;
    }

    public void setValues(HashMap<String, Object> values) {
        this.values = values;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public PluginResultType getResultType() {
        return resultType;
    }

    public void setResultType(PluginResultType resultType) {
        this.resultType = resultType;
    }
}
