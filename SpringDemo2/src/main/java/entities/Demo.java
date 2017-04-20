package entities;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Demo {
	private final Long id;
	private final String message;
	private Double latitude;
	private Double longitude;

	public Demo(Long id, String message, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.message = message;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Demo)) {
			return false;
		}
		Demo demo = (Demo) obj;
		return new EqualsBuilder().append(getId(), demo.getId()).isEquals();
	}

}
