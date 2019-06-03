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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Contact;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.ContactResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ContactSerDes;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
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
public abstract class BaseContactResourceTestCase {

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
		testLocale = LocaleUtil.getDefault();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_contactResource.setContextCompany(testCompany);
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

		Contact contact1 = randomContact();

		String json = objectMapper.writeValueAsString(contact1);

		Contact contact2 = ContactSerDes.toDTO(json);

		Assert.assertTrue(equals(contact1, contact2));
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

		Contact contact = randomContact();

		String json1 = objectMapper.writeValueAsString(contact);
		String json2 = ContactSerDes.toJSON(contact);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Contact contact = randomContact();

		contact.setEmailAddress(regex);
		contact.setFirstName(regex);
		contact.setLanguageId(regex);
		contact.setLastName(regex);
		contact.setMiddleName(regex);

		String json = ContactSerDes.toJSON(contact);

		Assert.assertFalse(json.contains(regex));

		contact = ContactSerDes.toDTO(json);

		Assert.assertEquals(regex, contact.getEmailAddress());
		Assert.assertEquals(regex, contact.getFirstName());
		Assert.assertEquals(regex, contact.getLanguageId());
		Assert.assertEquals(regex, contact.getLastName());
		Assert.assertEquals(regex, contact.getMiddleName());
	}

	@Test
	public void testGetAccountContactsPage() throws Exception {
		Long accountId = testGetAccountContactsPage_getAccountId();
		Long irrelevantAccountId =
			testGetAccountContactsPage_getIrrelevantAccountId();

		if ((irrelevantAccountId != null)) {
			Contact irrelevantContact = testGetAccountContactsPage_addContact(
				irrelevantAccountId, randomIrrelevantContact());

			Page<Contact> page = ContactResource.getAccountContactsPage(
				irrelevantAccountId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantContact),
				(List<Contact>)page.getItems());
			assertValid(page);
		}

		Contact contact1 = testGetAccountContactsPage_addContact(
			accountId, randomContact());

		Contact contact2 = testGetAccountContactsPage_addContact(
			accountId, randomContact());

		Page<Contact> page = ContactResource.getAccountContactsPage(
			accountId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(contact1, contact2), (List<Contact>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountContactsPageWithPagination() throws Exception {
		Long accountId = testGetAccountContactsPage_getAccountId();

		Contact contact1 = testGetAccountContactsPage_addContact(
			accountId, randomContact());

		Contact contact2 = testGetAccountContactsPage_addContact(
			accountId, randomContact());

		Contact contact3 = testGetAccountContactsPage_addContact(
			accountId, randomContact());

		Page<Contact> page1 = ContactResource.getAccountContactsPage(
			accountId, Pagination.of(1, 2));

		List<Contact> contacts1 = (List<Contact>)page1.getItems();

		Assert.assertEquals(contacts1.toString(), 2, contacts1.size());

		Page<Contact> page2 = ContactResource.getAccountContactsPage(
			accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<Contact> contacts2 = (List<Contact>)page2.getItems();

		Assert.assertEquals(contacts2.toString(), 1, contacts2.size());

		Page<Contact> page3 = ContactResource.getAccountContactsPage(
			accountId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(contact1, contact2, contact3),
			(List<Contact>)page3.getItems());
	}

	protected Contact testGetAccountContactsPage_addContact(
			Long accountId, Contact contact)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountContactsPage_getAccountId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountContactsPage_getIrrelevantAccountId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostContact() throws Exception {
		Contact randomContact = randomContact();

		Contact postContact = testPostContact_addContact(randomContact);

		assertEquals(randomContact, postContact);
		assertValid(postContact);
	}

	protected Contact testPostContact_addContact(Contact contact)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteContact() throws Exception {
		Contact contact = testDeleteContact_addContact();

		assertHttpResponseStatusCode(
			204, ContactResource.deleteContactHttpResponse(contact.getId()));

		assertHttpResponseStatusCode(
			404, ContactResource.getContactHttpResponse(contact.getId()));

		assertHttpResponseStatusCode(
			404, ContactResource.getContactHttpResponse(0L));
	}

	protected Contact testDeleteContact_addContact() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetContact() throws Exception {
		Contact postContact = testGetContact_addContact();

		Contact getContact = ContactResource.getContact(postContact.getId());

		assertEquals(postContact, getContact);
		assertValid(getContact);
	}

	protected Contact testGetContact_addContact() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProjectContactsPage() throws Exception {
		Long projectId = testGetProjectContactsPage_getProjectId();
		Long irrelevantProjectId =
			testGetProjectContactsPage_getIrrelevantProjectId();

		if ((irrelevantProjectId != null)) {
			Contact irrelevantContact = testGetProjectContactsPage_addContact(
				irrelevantProjectId, randomIrrelevantContact());

			Page<Contact> page = ContactResource.getProjectContactsPage(
				irrelevantProjectId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantContact),
				(List<Contact>)page.getItems());
			assertValid(page);
		}

		Contact contact1 = testGetProjectContactsPage_addContact(
			projectId, randomContact());

		Contact contact2 = testGetProjectContactsPage_addContact(
			projectId, randomContact());

		Page<Contact> page = ContactResource.getProjectContactsPage(
			projectId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(contact1, contact2), (List<Contact>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetProjectContactsPageWithPagination() throws Exception {
		Long projectId = testGetProjectContactsPage_getProjectId();

		Contact contact1 = testGetProjectContactsPage_addContact(
			projectId, randomContact());

		Contact contact2 = testGetProjectContactsPage_addContact(
			projectId, randomContact());

		Contact contact3 = testGetProjectContactsPage_addContact(
			projectId, randomContact());

		Page<Contact> page1 = ContactResource.getProjectContactsPage(
			projectId, Pagination.of(1, 2));

		List<Contact> contacts1 = (List<Contact>)page1.getItems();

		Assert.assertEquals(contacts1.toString(), 2, contacts1.size());

		Page<Contact> page2 = ContactResource.getProjectContactsPage(
			projectId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<Contact> contacts2 = (List<Contact>)page2.getItems();

		Assert.assertEquals(contacts2.toString(), 1, contacts2.size());

		Page<Contact> page3 = ContactResource.getProjectContactsPage(
			projectId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(contact1, contact2, contact3),
			(List<Contact>)page3.getItems());
	}

	protected Contact testGetProjectContactsPage_addContact(
			Long projectId, Contact contact)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetProjectContactsPage_getProjectId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetProjectContactsPage_getIrrelevantProjectId()
		throws Exception {

		return null;
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Contact contact1, Contact contact2) {
		Assert.assertTrue(
			contact1 + " does not equal " + contact2,
			equals(contact1, contact2));
	}

	protected void assertEquals(
		List<Contact> contacts1, List<Contact> contacts2) {

		Assert.assertEquals(contacts1.size(), contacts2.size());

		for (int i = 0; i < contacts1.size(); i++) {
			Contact contact1 = contacts1.get(i);
			Contact contact2 = contacts2.get(i);

			assertEquals(contact1, contact2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Contact> contacts1, List<Contact> contacts2) {

		Assert.assertEquals(contacts1.size(), contacts2.size());

		for (Contact contact1 : contacts1) {
			boolean contains = false;

			for (Contact contact2 : contacts2) {
				if (equals(contact1, contact2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				contacts2 + " does not contain " + contact1, contains);
		}
	}

	protected void assertValid(Contact contact) {
		boolean valid = true;

		if (contact.getDateCreated() == null) {
			valid = false;
		}

		if (contact.getDateModified() == null) {
			valid = false;
		}

		if (contact.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (contact.getEmailAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (contact.getExternalLinks() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (contact.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("languageId", additionalAssertFieldName)) {
				if (contact.getLanguageId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (contact.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("middleName", additionalAssertFieldName)) {
				if (contact.getMiddleName() == null) {
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

	protected void assertValid(Page<Contact> page) {
		boolean valid = false;

		Collection<Contact> contacts = page.getItems();

		int size = contacts.size();

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

	protected boolean equals(Contact contact1, Contact contact2) {
		if (contact1 == contact2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getDateCreated(), contact2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateModified", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getDateModified(),
						contact2.getDateModified())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getEmailAddress(),
						contact2.getEmailAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getExternalLinks(),
						contact2.getExternalLinks())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getFirstName(), contact2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(contact1.getId(), contact2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("languageId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getLanguageId(), contact2.getLanguageId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getLastName(), contact2.getLastName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("middleName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getMiddleName(), contact2.getMiddleName())) {

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

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_contactResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_contactResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Contact contact) {

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
						DateUtils.addSeconds(contact.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(contact.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(contact.getDateCreated()));
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
						DateUtils.addSeconds(contact.getDateModified(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(contact.getDateModified(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(contact.getDateModified()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("emailAddress")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getEmailAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalLinks")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("firstName")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getFirstName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("languageId")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getLanguageId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("lastName")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getLastName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("middleName")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getMiddleName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Contact randomContact() throws Exception {
		return new Contact() {
			{
				dateCreated = RandomTestUtil.nextDate();
				dateModified = RandomTestUtil.nextDate();
				emailAddress = RandomTestUtil.randomString();
				firstName = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				languageId = RandomTestUtil.randomString();
				lastName = RandomTestUtil.randomString();
				middleName = RandomTestUtil.randomString();
			}
		};
	}

	protected Contact randomIrrelevantContact() throws Exception {
		Contact randomIrrelevantContact = randomContact();

		return randomIrrelevantContact;
	}

	protected Contact randomPatchContact() throws Exception {
		return randomContact();
	}

	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseContactResourceTestCase.class);

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
	private com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactResource
		_contactResource;

}