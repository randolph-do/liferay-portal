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

package com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Address;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Region;

/**
 * @author Kyle Bischof
 */
public class AddressUtil {

	public static Address toAddress(
			com.liferay.portal.kernel.model.Address address)
		throws Exception {

		return new Address() {
			{
				city = address.getCity();
				className = address.getClassName();
				classPK = address.getClassPK();
				mailing = address.getMailing();
				primary = address.getPrimary();
				street1 = address.getStreet1();
				street2 = address.getStreet2();
				street3 = address.getStreet3();
				userId = address.getUserId();
				zip = address.getZip();

				setCountry(
					() -> {
						if (address.getCountryId() <= 0) {
							return null;
						}

						Country country = address.getCountry();

						return country.getName();
					});
				setRegion(
					() -> {
						if (address.getRegionId() <= 0) {
							return null;
						}

						Region region = address.getRegion();

						return region.getName();
					});
				setType(
					() -> {
						if (address.getTypeId() <= 0) {
							return null;
						}

						ListType type = address.getType();

						return type.getName();
					});
			}
		};
	}

}