/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.client.function.UnsafeSupplier;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProjectSerDes;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class Project {

	public static enum Industry {

		AEROSPACE_AND_DEFENSE("aerospace-and-defense"),
		AGRICULTURE("agriculture"), AUTOMOTIVE("automotive"),
		CONSULTING_MARKET_RESEARCH("consulting-market-research"),
		EDUCATION("education"), ENERGY("energy"), ENGINEERING("engineering"),
		FINANCIAL_SERVICES("financial-services"),
		FOOD_SERVICES("food-services"),
		GOVERNMENT_FEDERAL("government-federal"),
		GOVERNMENT_STATE_LOCAL("government-state-local"),
		HEALTHCARE("healthcare"), HOSPITALITY_LEISURE("hospitality-leisure"),
		INSURANCE("insurance"), MANUFACTURING("manufacturing"),
		MEDIA_ENTERTAINMENT("media-entertainment"),
		NOT_FOR_PROFIT_NGO("not-for-profit-ngo"), OTHER("other"),
		PHARMACEUTICALS("pharmaceuticals"),
		PROFESSIONAL_SERVICES_AGENCY_BUSINESS(
			"professional-services-agency-business"),
		PROFESSIONAL_SERVICES_TECHNICAL_WEB_IT(
			"professional-services-technical-web-it"),
		RETAIL_CONSUMER_PRODUCTS("retail-consumer-products"),
		TECHNOLOGY("technology"), TELECOMMUNICATION("telecommunication"),
		TRANSPORTATION("transportation"), UTILITIES("utilities");

		public static Industry create(String value) {
			for (Industry industry : values()) {
				if (Objects.equals(industry.getValue(), value)) {
					return industry;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Industry(String value) {
			_value = value;
		}

		private final String _value;

	}

	public static enum Status {

		APPROVED("approved"), CLOSED("closed"), EXPIRED("expired"),
		INACTIVE("inactive"), PENDING("pending"),
		PENDING_VALIDATION("pending-validation"), REJECTED("rejected");

		public static Status create(String value) {
			for (Status status : values()) {
				if (Objects.equals(status.getValue(), value)) {
					return status;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Status(String value) {
			_value = value;
		}

		private final String _value;

	}

	public static enum Tier {

		OEM("oem"), PREMIER("premier"), REGULAR("regular"),
		STRATEGIC("strategic");

		public static Tier create(String value) {
			for (Tier tier : values()) {
				if (Objects.equals(tier.getValue(), value)) {
					return tier;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Tier(String value) {
			_value = value;
		}

		private final String _value;

	}

	public String getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	public void setAccountKey(
		UnsafeSupplier<String, Exception> accountKeyUnsafeSupplier) {

		try {
			accountKey = accountKeyUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String accountKey;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCode(UnsafeSupplier<String, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String code;

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateCreated(
		UnsafeSupplier<Date, Exception> dateCreatedUnsafeSupplier) {

		try {
			dateCreated = dateCreatedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateCreated;

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public void setDateModified(
		UnsafeSupplier<Date, Exception> dateModifiedUnsafeSupplier) {

		try {
			dateModified = dateModifiedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateModified;

	public ExternalLink[] getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(ExternalLink[] externalLinks) {
		this.externalLinks = externalLinks;
	}

	public void setExternalLinks(
		UnsafeSupplier<ExternalLink[], Exception> externalLinksUnsafeSupplier) {

		try {
			externalLinks = externalLinksUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ExternalLink[] externalLinks;

	public Industry getIndustry() {
		return industry;
	}

	public String getIndustryAsString() {
		if (industry == null) {
			return null;
		}

		return industry.toString();
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public void setIndustry(
		UnsafeSupplier<Industry, Exception> industryUnsafeSupplier) {

		try {
			industry = industryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Industry industry;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setKey(UnsafeSupplier<String, Exception> keyUnsafeSupplier) {
		try {
			key = keyUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setNotes(
		UnsafeSupplier<String, Exception> notesUnsafeSupplier) {

		try {
			notes = notesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String notes;

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public void setSoldBy(
		UnsafeSupplier<String, Exception> soldByUnsafeSupplier) {

		try {
			soldBy = soldByUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String soldBy;

	public Status getStatus() {
		return status;
	}

	public String getStatusAsString() {
		if (status == null) {
			return null;
		}

		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Status status;

	public Tier getTier() {
		return tier;
	}

	public String getTierAsString() {
		if (tier == null) {
			return null;
		}

		return tier.toString();
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public void setTier(UnsafeSupplier<Tier, Exception> tierUnsafeSupplier) {
		try {
			tier = tierUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Tier tier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Project)) {
			return false;
		}

		Project project = (Project)object;

		return Objects.equals(toString(), project.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ProjectSerDes.toJSON(this);
	}

}