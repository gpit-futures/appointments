package com.answerdigital.appointment.dto;

import java.util.Date;
import java.util.List;

public class Slot extends ResponseDTO {

    private Long appointmentId;
    private Long typeCode;
    private String typeDisply;
    private Long scheduleReference;
    private String freeBusyType;
    private Date startDateTime;
    private Date endDateTime;
    private Date lastUpdated;
    private boolean gpConnectBookable;
    private List<Long> organizationIds;
    private List<String> organizationTypes;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Long typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeDisply() {
        return typeDisply;
    }

    public void setTypeDisply(String typeDisply) {
        this.typeDisply = typeDisply;
    }

    public Long getScheduleReference() {
        return scheduleReference;
    }

    public void setScheduleReference(Long scheduleReference) {
        this.scheduleReference = scheduleReference;
    }

    public String getFreeBusyType() {
        return freeBusyType;
    }

    public void setFreeBusyType(String freeBusyType) {
        this.freeBusyType = freeBusyType;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

	public boolean isGpConnectBookable() {
		return gpConnectBookable;
	}

	public void setGpConnectBookable(boolean gpConnectBookable) {
		this.gpConnectBookable = gpConnectBookable;
	}

	public List<Long> getOrganizationIds() {
		return organizationIds;
	}

	public void setOrganizationIds(List<Long> organizationIds) {
		this.organizationIds = organizationIds;
	}

	public List<String> getOrganizationTypes() {
		return organizationTypes;
	}

	public void setOrganizationTypes(List<String> organizationTypes) {
		this.organizationTypes = organizationTypes;
	}
}
