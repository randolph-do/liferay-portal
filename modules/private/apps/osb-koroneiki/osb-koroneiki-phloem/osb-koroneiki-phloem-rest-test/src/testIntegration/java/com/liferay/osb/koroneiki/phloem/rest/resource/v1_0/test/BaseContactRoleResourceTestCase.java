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

package com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ContactRole;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.ContactRoleResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ContactRoleSerDes;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public abstract class BaseContactRoleResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_contactRoleResource.setContextCompany(testCompany);

		ContactRoleResource.Builder builder = ContactRoleResource.builder();

		contactRoleResource = builder.locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		ContactRole contactRole1 = randomContactRole();

		String json = objectMapper.writeValueAsString(contactRole1);

		ContactRole contactRole2 = ContactRoleSerDes.toDTO(json);

		Assert.assertTrue(equals(contactRole1, contactRole2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		ContactRole contactRole = randomContactRole();

		String json1 = objectMapper.writeValueAsString(contactRole);
		String json2 = ContactRoleSerDes.toJSON(contactRole);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ContactRole contactRole = randomContactRole();

		contactRole.setDescription(regex);
		contactRole.setName(regex);

		String json = ContactRoleSerDes.toJSON(contactRole);

		Assert.assertFalse(json.contains(regex));

		contactRole = ContactRoleSerDes.toDTO(json);

		Assert.assertEquals(regex, contactRole.getDescription());
		Assert.assertEquals(regex, contactRole.getName());
	}

	@Test
	public void testPostContactRole() throws Exception {
		ContactRole randomContactRole = randomContactRole();

		ContactRole postContactRole = testPostContactRole_addContactRole(
			randomContactRole);

		assertEquals(randomContactRole, postContactRole);
		assertValid(postContactRole);
	}

	protected ContactRole testPostContactRole_addContactRole(
			ContactRole contactRole)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteContactRole() throws Exception {
		ContactRole contactRole = testDeleteContactRole_addContactRole();

		assertHttpResponseStatusCode(
			204,
			contactRoleResource.deleteContactRoleHttpResponse(
				contactRole.getId()));

		assertHttpResponseStatusCode(
			404,
			contactRoleResource.getContactRoleHttpResponse(
				contactRole.getId()));

		assertHttpResponseStatusCode(
			404, contactRoleResource.getContactRoleHttpResponse(0L));
	}

	protected ContactRole testDeleteContactRole_addContactRole()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetContactRole() throws Exception {
		ContactRole postContactRole = testGetContactRole_addContactRole();

		ContactRole getContactRole = contactRoleResource.getContactRole(
			postContactRole.getId());

		assertEquals(postContactRole, getContactRole);
		assertValid(getContactRole);
	}

	protected ContactRole testGetContactRole_addContactRole() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutContactRole() throws Exception {
		ContactRole postContactRole = testPutContactRole_addContactRole();

		ContactRole randomContactRole = randomContactRole();

		ContactRole putContactRole = contactRoleResource.putContactRole(
			postContactRole.getId(), randomContactRole);

		assertEquals(randomContactRole, putContactRole);
		assertValid(putContactRole);

		ContactRole getContactRole = contactRoleResource.getContactRole(
			putContactRole.getId());

		assertEquals(randomContactRole, getContactRole);
		assertValid(getContactRole);
	}

	protected ContactRole testPutContactRole_addContactRole() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ContactRole contactRole1, ContactRole contactRole2) {

		Assert.assertTrue(
			contactRole1 + " does not equal " + contactRole2,
			equals(contactRole1, contactRole2));
	}

	protected void assertEquals(
		List<ContactRole> contactRoles1, List<ContactRole> contactRoles2) {

		Assert.assertEquals(contactRoles1.size(), contactRoles2.size());

		for (int i = 0; i < contactRoles1.size(); i++) {
			ContactRole contactRole1 = contactRoles1.get(i);
			ContactRole contactRole2 = contactRoles2.get(i);

			assertEquals(contactRole1, contactRole2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ContactRole> contactRoles1, List<ContactRole> contactRoles2) {

		Assert.assertEquals(contactRoles1.size(), contactRoles2.size());

		for (ContactRole contactRole1 : contactRoles1) {
			boolean contains = false;

			for (ContactRole contactRole2 : contactRoles2) {
				if (equals(contactRole1, contactRole2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				contactRoles2 + " does not contain " + contactRole1, contains);
		}
	}

	protected void assertValid(ContactRole contactRole) {
		boolean valid = true;

		if (contactRole.getDateCreated() == null) {
			valid = false;
		}

		if (contactRole.getDateModified() == null) {
			valid = false;
		}

		if (contactRole.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (contactRole.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (contactRole.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("system", additionalAssertFieldName)) {
				if (contactRole.getSystem() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (contactRole.getType() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<ContactRole> page) {
		boolean valid = false;

		java.util.Collection<ContactRole> contactRoles = page.getItems();

		int size = contactRoles.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		ContactRole contactRole1, ContactRole contactRole2) {

		if (contactRole1 == contactRole2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getDateCreated(),
						contactRole2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateModified", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getDateModified(),
						contactRole2.getDateModified())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getDescription(),
						contactRole2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getId(), contactRole2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getName(), contactRole2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("system", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getSystem(), contactRole2.getSystem())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactRole1.getType(), contactRole2.getType())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_contactRoleResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_contactRoleResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, ContactRole contactRole) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("dateCreated")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							contactRole.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(contactRole.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(contactRole.getDateCreated()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("dateModified")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							contactRole.getDateModified(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							contactRole.getDateModified(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(contactRole.getDateModified()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(contactRole.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(contactRole.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("system")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("type")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected ContactRole randomContactRole() throws Exception {
		return new ContactRole() {
			{
				dateCreated = RandomTestUtil.nextDate();
				dateModified = RandomTestUtil.nextDate();
				description = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				name = RandomTestUtil.randomString();
				system = RandomTestUtil.randomBoolean();
			}
		};
	}

	protected ContactRole randomIrrelevantContactRole() throws Exception {
		ContactRole randomIrrelevantContactRole = randomContactRole();

		return randomIrrelevantContactRole;
	}

	protected ContactRole randomPatchContactRole() throws Exception {
		return randomContactRole();
	}

	protected ContactRoleResource contactRoleResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	private static final Log _log = LogFactoryUtil.getLog(
		BaseContactRoleResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private
		com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactRoleResource
			_contactRoleResource;

}