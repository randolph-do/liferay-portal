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

package com.liferay.osb.koroneiki.phloem.rest.internal.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.PostalAddress;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.PostalAddressUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.PostalAddressResource;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.service.AccountService;
import com.liferay.osb.koroneiki.taproot.service.AddressService;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.ListTypeService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Kyle Bischof
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/postal-address.properties",
	scope = ServiceScope.PROTOTYPE, service = PostalAddressResource.class
)
public class PostalAddressResourceImpl extends BasePostalAddressResourceImpl {

	@Override
	public void deletePostalAddress(Long postalAddressId) throws Exception {
		_addressService.deleteAddress(postalAddressId);
	}

	@Override
	public Page<PostalAddress> getAccountPostalAddressesPage(Long accountId)
		throws Exception {

		Account account = _accountService.getAccount(accountId);

		return Page.of(
			transform(
				account.getAddresses(),
				address -> PostalAddressUtil.toPostalAddress(
					address, contextAcceptLanguage.getPreferredLocale())));
	}

	@Override
	public PostalAddress getPostalAddress(Long postalAddressId)
		throws Exception {

		return PostalAddressUtil.toPostalAddress(
			_addressService.getAddress(postalAddressId),
			contextAcceptLanguage.getPreferredLocale());
	}

	@Override
	public PostalAddress postAccountPostalAddress(
			Long accountId, PostalAddress postalAddress)
		throws Exception {

		Country country = _countryService.getCountryByName(
			postalAddress.getAddressCountry());

		Region region = _regionService.getRegion(
			country.getCountryId(), postalAddress.getAddressRegion());

		ListType listType = _listTypeService.getListType(
			postalAddress.getAddressType(),
			Contact.class.getName() + ".address");

		return PostalAddressUtil.toPostalAddress(
			_addressService.addAddress(
				Account.class.getName(), accountId,
				postalAddress.getStreetAddressLine1(),
				postalAddress.getStreetAddressLine2(),
				postalAddress.getStreetAddressLine2(),
				postalAddress.getAddressLocality(),
				postalAddress.getPostalCode(), region.getRegionId(),
				country.getCountryId(), listType.getListTypeId(),
				postalAddress.getMailing(), postalAddress.getPrimary(),
				new ServiceContext()),
			contextAcceptLanguage.getPreferredLocale());
	}

	@Override
	public PostalAddress putPostalAddress(
			Long postalAddressId, PostalAddress postalAddress)
		throws Exception {

		Country country = _countryService.getCountryByName(
			postalAddress.getAddressCountry());

		Region region = _regionService.getRegion(
			country.getCountryId(), postalAddress.getAddressRegion());

		ListType listType = _listTypeService.getListType(
			postalAddress.getAddressType(),
			Contact.class.getName() + ".address");

		return PostalAddressUtil.toPostalAddress(
			_addressService.updateAddress(
				postalAddressId, postalAddress.getStreetAddressLine1(),
				postalAddress.getStreetAddressLine2(),
				postalAddress.getStreetAddressLine2(),
				postalAddress.getAddressLocality(),
				postalAddress.getPostalCode(), region.getRegionId(),
				country.getCountryId(), listType.getListTypeId(),
				postalAddress.getMailing(), postalAddress.getPrimary()),
			contextAcceptLanguage.getPreferredLocale());
	}

	@Reference
	private AccountService _accountService;

	@Reference
	private AddressService _addressService;

	@Reference
	private CountryService _countryService;

	@Reference
	private ListTypeService _listTypeService;

	@Reference
	private RegionService _regionService;

}