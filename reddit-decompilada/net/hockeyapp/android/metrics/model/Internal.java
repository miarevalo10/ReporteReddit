package net.hockeyapp.android.metrics.model;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Map;
import net.hockeyapp.android.metrics.JsonHelper;

public class Internal implements Serializable {
    private String accountId;
    private String agentVersion;
    private String applicationName;
    private String applicationType;
    private String dataCollectorReceivedTime;
    private String flowType;
    private String instrumentationKey;
    private String isAudit;
    private String profileClassId;
    private String profileId;
    private String requestSource;
    private String sdkVersion;
    private String telemetryItemId;
    private String trackingSourceId;
    private String trackingType;

    protected void InitializeFields() {
    }

    public Internal() {
        InitializeFields();
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getAgentVersion() {
        return this.agentVersion;
    }

    public void setAgentVersion(String str) {
        this.agentVersion = str;
    }

    public String getDataCollectorReceivedTime() {
        return this.dataCollectorReceivedTime;
    }

    public void setDataCollectorReceivedTime(String str) {
        this.dataCollectorReceivedTime = str;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public String getProfileClassId() {
        return this.profileClassId;
    }

    public void setProfileClassId(String str) {
        this.profileClassId = str;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public void setApplicationName(String str) {
        this.applicationName = str;
    }

    public String getInstrumentationKey() {
        return this.instrumentationKey;
    }

    public void setInstrumentationKey(String str) {
        this.instrumentationKey = str;
    }

    public String getTelemetryItemId() {
        return this.telemetryItemId;
    }

    public void setTelemetryItemId(String str) {
        this.telemetryItemId = str;
    }

    public String getApplicationType() {
        return this.applicationType;
    }

    public void setApplicationType(String str) {
        this.applicationType = str;
    }

    public String getRequestSource() {
        return this.requestSource;
    }

    public void setRequestSource(String str) {
        this.requestSource = str;
    }

    public String getFlowType() {
        return this.flowType;
    }

    public void setFlowType(String str) {
        this.flowType = str;
    }

    public String getIsAudit() {
        return this.isAudit;
    }

    public void setIsAudit(String str) {
        this.isAudit = str;
    }

    public String getTrackingSourceId() {
        return this.trackingSourceId;
    }

    public void setTrackingSourceId(String str) {
        this.trackingSourceId = str;
    }

    public String getTrackingType() {
        return this.trackingType;
    }

    public void setTrackingType(String str) {
        this.trackingType = str;
    }

    public void addToHashMap(Map<String, String> map) {
        if (this.sdkVersion != null) {
            map.put("ai.internal.sdkVersion", this.sdkVersion);
        }
        if (this.agentVersion != null) {
            map.put("ai.internal.agentVersion", this.agentVersion);
        }
        if (this.dataCollectorReceivedTime != null) {
            map.put("ai.internal.dataCollectorReceivedTime", this.dataCollectorReceivedTime);
        }
        if (this.profileId != null) {
            map.put("ai.internal.profileId", this.profileId);
        }
        if (this.profileClassId != null) {
            map.put("ai.internal.profileClassId", this.profileClassId);
        }
        if (this.accountId != null) {
            map.put("ai.internal.accountId", this.accountId);
        }
        if (this.applicationName != null) {
            map.put("ai.internal.applicationName", this.applicationName);
        }
        if (this.instrumentationKey != null) {
            map.put("ai.internal.instrumentationKey", this.instrumentationKey);
        }
        if (this.telemetryItemId != null) {
            map.put("ai.internal.telemetryItemId", this.telemetryItemId);
        }
        if (this.applicationType != null) {
            map.put("ai.internal.applicationType", this.applicationType);
        }
        if (this.requestSource != null) {
            map.put("ai.internal.requestSource", this.requestSource);
        }
        if (this.flowType != null) {
            map.put("ai.internal.flowType", this.flowType);
        }
        if (this.isAudit != null) {
            map.put("ai.internal.isAudit", this.isAudit);
        }
        if (this.trackingSourceId != null) {
            map.put("ai.internal.trackingSourceId", this.trackingSourceId);
        }
        if (this.trackingType != null) {
            map.put("ai.internal.trackingType", this.trackingType);
        }
    }

    public void serialize(Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("writer");
        }
        writer.write(123);
        serializeContent(writer);
        writer.write(125);
    }

    protected String serializeContent(Writer writer) throws IOException {
        String str = "";
        if (this.sdkVersion != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.sdkVersion\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.sdkVersion));
            str = ",";
        }
        if (this.agentVersion != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.agentVersion\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.agentVersion));
            str = ",";
        }
        if (this.dataCollectorReceivedTime != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.dataCollectorReceivedTime\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.dataCollectorReceivedTime));
            str = ",";
        }
        if (this.profileId != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.profileId\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.profileId));
            str = ",";
        }
        if (this.profileClassId != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.profileClassId\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.profileClassId));
            str = ",";
        }
        if (this.accountId != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.accountId\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.accountId));
            str = ",";
        }
        if (this.applicationName != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.applicationName\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.applicationName));
            str = ",";
        }
        if (this.instrumentationKey != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.instrumentationKey\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.instrumentationKey));
            str = ",";
        }
        if (this.telemetryItemId != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.telemetryItemId\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.telemetryItemId));
            str = ",";
        }
        if (this.applicationType != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.applicationType\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.applicationType));
            str = ",";
        }
        if (this.requestSource != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.requestSource\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.requestSource));
            str = ",";
        }
        if (this.flowType != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.flowType\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.flowType));
            str = ",";
        }
        if (this.isAudit != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.isAudit\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.isAudit));
            str = ",";
        }
        if (this.trackingSourceId != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\"ai.internal.trackingSourceId\":");
            writer.write(stringBuilder.toString());
            writer.write(JsonHelper.m28184a(this.trackingSourceId));
            str = ",";
        }
        if (this.trackingType == null) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\"ai.internal.trackingType\":");
        writer.write(stringBuilder.toString());
        writer.write(JsonHelper.m28184a(this.trackingType));
        return ",";
    }
}
