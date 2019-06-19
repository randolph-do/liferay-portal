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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Address;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.AddressUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AddressResource;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.service.AccountService;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.ListTypeService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Kyle Bischof
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/address.properties",
	scope = ServiceScope.PROTOTYPE, service = AddressResource.class
)
public class AddressResourceImpl extends BaseAddressResourceImpl {

	@Override
	public void deleteAddress(Long addressId) throws Exception {
		_addressLocalService.deleteAddress(addressId);
	}

	@Override
	public Page<Address> getAccountAddressesPage(
			Long accountId, Pagination pagination)
		throws Exception {

		Account account = _accountService.getAccount(accountId);

		List<com.liferay.portal.kernel.model.Address> addresses =
			account.getAddresses();

		int endPosition = pagination.getEndPosition();

		if (endPosition > addresses.size()) {
			endPosition = addresses.size();
		}

		List<com.liferay.portal.kernel.model.Address> sublist =
			addresses.subList(pagination.getStartPosition(), endPosition);

		return Page.of(
			transform(sublist, AddressUtil::toAddress), pagination,
			addresses.size());
	}

	@Override
	public Address getAddress(Long addressId) throws Exception {
		return AddressUtil.toAddress(
			_addressLocalService.getAddress(addressId));
	}

	@Override
	public Address postAddress(Address address) throws Exception {
		Country country = _countryService.getCountryByName(
			address.getCountry());

		Region region = _regionService.getRegion(
			country.getCountryId(), address.getRegion());

		ListType type = _listTypeService.getListType(
			address.getType(), Contact.class.getName() + ".address");

		return AddressUtil.toAddress(
			_addressLocalService.addAddress(
				address.getUserId(), address.getClassName(),
				address.getClassPK(), address.getStreet1(),
				address.getStreet2(), address.getStreet3(), address.getCity(),
				address.getZip(), region.getRegionId(), country.getCountryId(),
				type.getListTypeId(), address.getMailing(),
				address.getPrimary(), new ServiceContext()));
	}

	@Override
	public Address putAddress(Long addressId, Address address)
		throws Exception {

		Country country = _countryService.getCountryByName(
			address.getCountry());

		Region region = _regionService.getRegion(
			country.getCountryId(), address.getRegion());

		ListType type = _listTypeService.getListType(
			address.getType(), Contact.class.getName() + ".address");

		return AddressUtil.toAddress(
			_addressLocalService.updateAddress(
				addressId, address.getStreet1(), address.getStreet2(),
				address.getStreet3(), address.getCity(), address.getZip(),
				region.getRegionId(), country.getCountryId(),
				type.getListTypeId(), address.getMailing(),
				address.getPrimary()));
	}

	@Reference
	private AccountService _accountService;

	@Reference
	private AddressLocalService _addressLocalService;

	@Reference
	private CountryService _countryService;

	@Reference
	private ListTypeService _listTypeService;

	@Reference
	private RegionService _regionService;

}