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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.AuditEntry;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.AuditEntryResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.AuditEntrySerDes;
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
public abstract class BaseAuditEntryResourceTestCase {

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

		_auditEntryResource.setContextCompany(testCompany);
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

		AuditEntry auditEntry1 = randomAuditEntry();

		String json = objectMapper.writeValueAsString(auditEntry1);

		AuditEntry auditEntry2 = AuditEntrySerDes.toDTO(json);

		Assert.assertTrue(equals(auditEntry1, auditEntry2));
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

		AuditEntry auditEntry = randomAuditEntry();

		String json1 = objectMapper.writeValueAsString(auditEntry);
		String json2 = AuditEntrySerDes.toJSON(auditEntry);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		AuditEntry auditEntry = randomAuditEntry();

		auditEntry.setAction(regex);
		auditEntry.setClassName(regex);
		auditEntry.setDescription(regex);
		auditEntry.setField(regex);
		auditEntry.setFieldClassName(regex);
		auditEntry.setNewValue(regex);
		auditEntry.setOldValue(regex);
		auditEntry.setUserName(regex);

		String json = AuditEntrySerDes.toJSON(auditEntry);

		Assert.assertFalse(json.contains(regex));

		auditEntry = AuditEntrySerDes.toDTO(json);

		Assert.assertEquals(regex, auditEntry.getAction());
		Assert.assertEquals(regex, auditEntry.getClassName());
		Assert.assertEquals(regex, auditEntry.getDescription());
		Assert.assertEquals(regex, auditEntry.getField());
		Assert.assertEquals(regex, auditEntry.getFieldClassName());
		Assert.assertEquals(regex, auditEntry.getNewValue());
		Assert.assertEquals(regex, auditEntry.getOldValue());
		Assert.assertEquals(regex, auditEntry.getUserName());
	}

	@Test
	public void testGetAccountAuditEntriesPage() throws Exception {
		Long accountId = testGetAccountAuditEntriesPage_getAccountId();
		Long irrelevantAccountId =
			testGetAccountAuditEntriesPage_getIrrelevantAccountId();

		if ((irrelevantAccountId != null)) {
			AuditEntry irrelevantAuditEntry =
				testGetAccountAuditEntriesPage_addAuditEntry(
					irrelevantAccountId, randomIrrelevantAuditEntry());

			Page<AuditEntry> page =
				AuditEntryResource.getAccountAuditEntriesPage(
					irrelevantAccountId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantAuditEntry),
				(List<AuditEntry>)page.getItems());
			assertValid(page);
		}

		AuditEntry auditEntry1 = testGetAccountAuditEntriesPage_addAuditEntry(
			accountId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetAccountAuditEntriesPage_addAuditEntry(
			accountId, randomAuditEntry());

		Page<AuditEntry> page = AuditEntryResource.getAccountAuditEntriesPage(
			accountId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2),
			(List<AuditEntry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountAuditEntriesPageWithPagination()
		throws Exception {

		Long accountId = testGetAccountAuditEntriesPage_getAccountId();

		AuditEntry auditEntry1 = testGetAccountAuditEntriesPage_addAuditEntry(
			accountId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetAccountAuditEntriesPage_addAuditEntry(
			accountId, randomAuditEntry());

		AuditEntry auditEntry3 = testGetAccountAuditEntriesPage_addAuditEntry(
			accountId, randomAuditEntry());

		Page<AuditEntry> page1 = AuditEntryResource.getAccountAuditEntriesPage(
			accountId, Pagination.of(1, 2));

		List<AuditEntry> auditEntries1 = (List<AuditEntry>)page1.getItems();

		Assert.assertEquals(auditEntries1.toString(), 2, auditEntries1.size());

		Page<AuditEntry> page2 = AuditEntryResource.getAccountAuditEntriesPage(
			accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<AuditEntry> auditEntries2 = (List<AuditEntry>)page2.getItems();

		Assert.assertEquals(auditEntries2.toString(), 1, auditEntries2.size());

		Page<AuditEntry> page3 = AuditEntryResource.getAccountAuditEntriesPage(
			accountId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2, auditEntry3),
			(List<AuditEntry>)page3.getItems());
	}

	protected AuditEntry testGetAccountAuditEntriesPage_addAuditEntry(
			Long accountId, AuditEntry auditEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountAuditEntriesPage_getAccountId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountAuditEntriesPage_getIrrelevantAccountId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetAuditEntry() throws Exception {
		AuditEntry postAuditEntry = testGetAuditEntry_addAuditEntry();

		AuditEntry getAuditEntry = AuditEntryResource.getAuditEntry(
			postAuditEntry.getId());

		assertEquals(postAuditEntry, getAuditEntry);
		assertValid(getAuditEntry);
	}

	protected AuditEntry testGetAuditEntry_addAuditEntry() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetContactRoleAuditEntriesPage() throws Exception {
		Long contactRoleId =
			testGetContactRoleAuditEntriesPage_getContactRoleId();
		Long irrelevantContactRoleId =
			testGetContactRoleAuditEntriesPage_getIrrelevantContactRoleId();

		if ((irrelevantContactRoleId != null)) {
			AuditEntry irrelevantAuditEntry =
				testGetContactRoleAuditEntriesPage_addAuditEntry(
					irrelevantContactRoleId, randomIrrelevantAuditEntry());

			Page<AuditEntry> page =
				AuditEntryResource.getContactRoleAuditEntriesPage(
					irrelevantContactRoleId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantAuditEntry),
				(List<AuditEntry>)page.getItems());
			assertValid(page);
		}

		AuditEntry auditEntry1 =
			testGetContactRoleAuditEntriesPage_addAuditEntry(
				contactRoleId, randomAuditEntry());

		AuditEntry auditEntry2 =
			testGetContactRoleAuditEntriesPage_addAuditEntry(
				contactRoleId, randomAuditEntry());

		Page<AuditEntry> page =
			AuditEntryResource.getContactRoleAuditEntriesPage(
				contactRoleId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2),
			(List<AuditEntry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetContactRoleAuditEntriesPageWithPagination()
		throws Exception {

		Long contactRoleId =
			testGetContactRoleAuditEntriesPage_getContactRoleId();

		AuditEntry auditEntry1 =
			testGetContactRoleAuditEntriesPage_addAuditEntry(
				contactRoleId, randomAuditEntry());

		AuditEntry auditEntry2 =
			testGetContactRoleAuditEntriesPage_addAuditEntry(
				contactRoleId, randomAuditEntry());

		AuditEntry auditEntry3 =
			testGetContactRoleAuditEntriesPage_addAuditEntry(
				contactRoleId, randomAuditEntry());

		Page<AuditEntry> page1 =
			AuditEntryResource.getContactRoleAuditEntriesPage(
				contactRoleId, Pagination.of(1, 2));

		List<AuditEntry> auditEntries1 = (List<AuditEntry>)page1.getItems();

		Assert.assertEquals(auditEntries1.toString(), 2, auditEntries1.size());

		Page<AuditEntry> page2 =
			AuditEntryResource.getContactRoleAuditEntriesPage(
				contactRoleId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<AuditEntry> auditEntries2 = (List<AuditEntry>)page2.getItems();

		Assert.assertEquals(auditEntries2.toString(), 1, auditEntries2.size());

		Page<AuditEntry> page3 =
			AuditEntryResource.getContactRoleAuditEntriesPage(
				contactRoleId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2, auditEntry3),
			(List<AuditEntry>)page3.getItems());
	}

	protected AuditEntry testGetContactRoleAuditEntriesPage_addAuditEntry(
			Long contactRoleId, AuditEntry auditEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetContactRoleAuditEntriesPage_getContactRoleId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetContactRoleAuditEntriesPage_getIrrelevantContactRoleId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetContactAuditEntriesPage() throws Exception {
		Long contactId = testGetContactAuditEntriesPage_getContactId();
		Long irrelevantContactId =
			testGetContactAuditEntriesPage_getIrrelevantContactId();

		if ((irrelevantContactId != null)) {
			AuditEntry irrelevantAuditEntry =
				testGetContactAuditEntriesPage_addAuditEntry(
					irrelevantContactId, randomIrrelevantAuditEntry());

			Page<AuditEntry> page =
				AuditEntryResource.getContactAuditEntriesPage(
					irrelevantContactId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantAuditEntry),
				(List<AuditEntry>)page.getItems());
			assertValid(page);
		}

		AuditEntry auditEntry1 = testGetContactAuditEntriesPage_addAuditEntry(
			contactId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetContactAuditEntriesPage_addAuditEntry(
			contactId, randomAuditEntry());

		Page<AuditEntry> page = AuditEntryResource.getContactAuditEntriesPage(
			contactId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2),
			(List<AuditEntry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetContactAuditEntriesPageWithPagination()
		throws Exception {

		Long contactId = testGetContactAuditEntriesPage_getContactId();

		AuditEntry auditEntry1 = testGetContactAuditEntriesPage_addAuditEntry(
			contactId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetContactAuditEntriesPage_addAuditEntry(
			contactId, randomAuditEntry());

		AuditEntry auditEntry3 = testGetContactAuditEntriesPage_addAuditEntry(
			contactId, randomAuditEntry());

		Page<AuditEntry> page1 = AuditEntryResource.getContactAuditEntriesPage(
			contactId, Pagination.of(1, 2));

		List<AuditEntry> auditEntries1 = (List<AuditEntry>)page1.getItems();

		Assert.assertEquals(auditEntries1.toString(), 2, auditEntries1.size());

		Page<AuditEntry> page2 = AuditEntryResource.getContactAuditEntriesPage(
			contactId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<AuditEntry> auditEntries2 = (List<AuditEntry>)page2.getItems();

		Assert.assertEquals(auditEntries2.toString(), 1, auditEntries2.size());

		Page<AuditEntry> page3 = AuditEntryResource.getContactAuditEntriesPage(
			contactId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2, auditEntry3),
			(List<AuditEntry>)page3.getItems());
	}

	protected AuditEntry testGetContactAuditEntriesPage_addAuditEntry(
			Long contactId, AuditEntry auditEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetContactAuditEntriesPage_getContactId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetContactAuditEntriesPage_getIrrelevantContactId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetProjectAuditEntriesPage() throws Exception {
		Long projectId = testGetProjectAuditEntriesPage_getProjectId();
		Long irrelevantProjectId =
			testGetProjectAuditEntriesPage_getIrrelevantProjectId();

		if ((irrelevantProjectId != null)) {
			AuditEntry irrelevantAuditEntry =
				testGetProjectAuditEntriesPage_addAuditEntry(
					irrelevantProjectId, randomIrrelevantAuditEntry());

			Page<AuditEntry> page =
				AuditEntryResource.getProjectAuditEntriesPage(
					irrelevantProjectId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantAuditEntry),
				(List<AuditEntry>)page.getItems());
			assertValid(page);
		}

		AuditEntry auditEntry1 = testGetProjectAuditEntriesPage_addAuditEntry(
			projectId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetProjectAuditEntriesPage_addAuditEntry(
			projectId, randomAuditEntry());

		Page<AuditEntry> page = AuditEntryResource.getProjectAuditEntriesPage(
			projectId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2),
			(List<AuditEntry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetProjectAuditEntriesPageWithPagination()
		throws Exception {

		Long projectId = testGetProjectAuditEntriesPage_getProjectId();

		AuditEntry auditEntry1 = testGetProjectAuditEntriesPage_addAuditEntry(
			projectId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetProjectAuditEntriesPage_addAuditEntry(
			projectId, randomAuditEntry());

		AuditEntry auditEntry3 = testGetProjectAuditEntriesPage_addAuditEntry(
			projectId, randomAuditEntry());

		Page<AuditEntry> page1 = AuditEntryResource.getProjectAuditEntriesPage(
			projectId, Pagination.of(1, 2));

		List<AuditEntry> auditEntries1 = (List<AuditEntry>)page1.getItems();

		Assert.assertEquals(auditEntries1.toString(), 2, auditEntries1.size());

		Page<AuditEntry> page2 = AuditEntryResource.getProjectAuditEntriesPage(
			projectId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<AuditEntry> auditEntries2 = (List<AuditEntry>)page2.getItems();

		Assert.assertEquals(auditEntries2.toString(), 1, auditEntries2.size());

		Page<AuditEntry> page3 = AuditEntryResource.getProjectAuditEntriesPage(
			projectId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2, auditEntry3),
			(List<AuditEntry>)page3.getItems());
	}

	protected AuditEntry testGetProjectAuditEntriesPage_addAuditEntry(
			Long projectId, AuditEntry auditEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetProjectAuditEntriesPage_getProjectId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetProjectAuditEntriesPage_getIrrelevantProjectId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetTeamRoleAuditEntriesPage() throws Exception {
		Long teamRoleId = testGetTeamRoleAuditEntriesPage_getTeamRoleId();
		Long irrelevantTeamRoleId =
			testGetTeamRoleAuditEntriesPage_getIrrelevantTeamRoleId();

		if ((irrelevantTeamRoleId != null)) {
			AuditEntry irrelevantAuditEntry =
				testGetTeamRoleAuditEntriesPage_addAuditEntry(
					irrelevantTeamRoleId, randomIrrelevantAuditEntry());

			Page<AuditEntry> page =
				AuditEntryResource.getTeamRoleAuditEntriesPage(
					irrelevantTeamRoleId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantAuditEntry),
				(List<AuditEntry>)page.getItems());
			assertValid(page);
		}

		AuditEntry auditEntry1 = testGetTeamRoleAuditEntriesPage_addAuditEntry(
			teamRoleId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetTeamRoleAuditEntriesPage_addAuditEntry(
			teamRoleId, randomAuditEntry());

		Page<AuditEntry> page = AuditEntryResource.getTeamRoleAuditEntriesPage(
			teamRoleId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2),
			(List<AuditEntry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTeamRoleAuditEntriesPageWithPagination()
		throws Exception {

		Long teamRoleId = testGetTeamRoleAuditEntriesPage_getTeamRoleId();

		AuditEntry auditEntry1 = testGetTeamRoleAuditEntriesPage_addAuditEntry(
			teamRoleId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetTeamRoleAuditEntriesPage_addAuditEntry(
			teamRoleId, randomAuditEntry());

		AuditEntry auditEntry3 = testGetTeamRoleAuditEntriesPage_addAuditEntry(
			teamRoleId, randomAuditEntry());

		Page<AuditEntry> page1 = AuditEntryResource.getTeamRoleAuditEntriesPage(
			teamRoleId, Pagination.of(1, 2));

		List<AuditEntry> auditEntries1 = (List<AuditEntry>)page1.getItems();

		Assert.assertEquals(auditEntries1.toString(), 2, auditEntries1.size());

		Page<AuditEntry> page2 = AuditEntryResource.getTeamRoleAuditEntriesPage(
			teamRoleId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<AuditEntry> auditEntries2 = (List<AuditEntry>)page2.getItems();

		Assert.assertEquals(auditEntries2.toString(), 1, auditEntries2.size());

		Page<AuditEntry> page3 = AuditEntryResource.getTeamRoleAuditEntriesPage(
			teamRoleId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2, auditEntry3),
			(List<AuditEntry>)page3.getItems());
	}

	protected AuditEntry testGetTeamRoleAuditEntriesPage_addAuditEntry(
			Long teamRoleId, AuditEntry auditEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTeamRoleAuditEntriesPage_getTeamRoleId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTeamRoleAuditEntriesPage_getIrrelevantTeamRoleId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetTeamAuditEntriesPage() throws Exception {
		Long teamId = testGetTeamAuditEntriesPage_getTeamId();
		Long irrelevantTeamId =
			testGetTeamAuditEntriesPage_getIrrelevantTeamId();

		if ((irrelevantTeamId != null)) {
			AuditEntry irrelevantAuditEntry =
				testGetTeamAuditEntriesPage_addAuditEntry(
					irrelevantTeamId, randomIrrelevantAuditEntry());

			Page<AuditEntry> page = AuditEntryResource.getTeamAuditEntriesPage(
				irrelevantTeamId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantAuditEntry),
				(List<AuditEntry>)page.getItems());
			assertValid(page);
		}

		AuditEntry auditEntry1 = testGetTeamAuditEntriesPage_addAuditEntry(
			teamId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetTeamAuditEntriesPage_addAuditEntry(
			teamId, randomAuditEntry());

		Page<AuditEntry> page = AuditEntryResource.getTeamAuditEntriesPage(
			teamId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2),
			(List<AuditEntry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTeamAuditEntriesPageWithPagination() throws Exception {
		Long teamId = testGetTeamAuditEntriesPage_getTeamId();

		AuditEntry auditEntry1 = testGetTeamAuditEntriesPage_addAuditEntry(
			teamId, randomAuditEntry());

		AuditEntry auditEntry2 = testGetTeamAuditEntriesPage_addAuditEntry(
			teamId, randomAuditEntry());

		AuditEntry auditEntry3 = testGetTeamAuditEntriesPage_addAuditEntry(
			teamId, randomAuditEntry());

		Page<AuditEntry> page1 = AuditEntryResource.getTeamAuditEntriesPage(
			teamId, Pagination.of(1, 2));

		List<AuditEntry> auditEntries1 = (List<AuditEntry>)page1.getItems();

		Assert.assertEquals(auditEntries1.toString(), 2, auditEntries1.size());

		Page<AuditEntry> page2 = AuditEntryResource.getTeamAuditEntriesPage(
			teamId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<AuditEntry> auditEntries2 = (List<AuditEntry>)page2.getItems();

		Assert.assertEquals(auditEntries2.toString(), 1, auditEntries2.size());

		Page<AuditEntry> page3 = AuditEntryResource.getTeamAuditEntriesPage(
			teamId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(auditEntry1, auditEntry2, auditEntry3),
			(List<AuditEntry>)page3.getItems());
	}

	protected AuditEntry testGetTeamAuditEntriesPage_addAuditEntry(
			Long teamId, AuditEntry auditEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTeamAuditEntriesPage_getTeamId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTeamAuditEntriesPage_getIrrelevantTeamId()
		throws Exception {

		return null;
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		AuditEntry auditEntry1, AuditEntry auditEntry2) {

		Assert.assertTrue(
			auditEntry1 + " does not equal " + auditEntry2,
			equals(auditEntry1, auditEntry2));
	}

	protected void assertEquals(
		List<AuditEntry> auditEntries1, List<AuditEntry> auditEntries2) {

		Assert.assertEquals(auditEntries1.size(), auditEntries2.size());

		for (int i = 0; i < auditEntries1.size(); i++) {
			AuditEntry auditEntry1 = auditEntries1.get(i);
			AuditEntry auditEntry2 = auditEntries2.get(i);

			assertEquals(auditEntry1, auditEntry2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<AuditEntry> auditEntries1, List<AuditEntry> auditEntries2) {

		Assert.assertEquals(auditEntries1.size(), auditEntries2.size());

		for (AuditEntry auditEntry1 : auditEntries1) {
			boolean contains = false;

			for (AuditEntry auditEntry2 : auditEntries2) {
				if (equals(auditEntry1, auditEntry2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				auditEntries2 + " does not contain " + auditEntry1, contains);
		}
	}

	protected void assertValid(AuditEntry auditEntry) {
		boolean valid = true;

		if (auditEntry.getDateCreated() == null) {
			valid = false;
		}

		if (auditEntry.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("action", additionalAssertFieldName)) {
				if (auditEntry.getAction() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("auditSetId", additionalAssertFieldName)) {
				if (auditEntry.getAuditSetId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("className", additionalAssertFieldName)) {
				if (auditEntry.getClassName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("classPK", additionalAssertFieldName)) {
				if (auditEntry.getClassPK() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (auditEntry.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("field", additionalAssertFieldName)) {
				if (auditEntry.getField() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fieldClassName", additionalAssertFieldName)) {
				if (auditEntry.getFieldClassName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fieldClassPK", additionalAssertFieldName)) {
				if (auditEntry.getFieldClassPK() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("newValue", additionalAssertFieldName)) {
				if (auditEntry.getNewValue() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("oldValue", additionalAssertFieldName)) {
				if (auditEntry.getOldValue() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (auditEntry.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (auditEntry.getUserName() == null) {
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

	protected void assertValid(Page<AuditEntry> page) {
		boolean valid = false;

		Collection<AuditEntry> auditEntries = page.getItems();

		int size = auditEntries.size();

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

	protected boolean equals(AuditEntry auditEntry1, AuditEntry auditEntry2) {
		if (auditEntry1 == auditEntry2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("action", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getAction(), auditEntry2.getAction())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("auditSetId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getAuditSetId(),
						auditEntry2.getAuditSetId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("className", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getClassName(),
						auditEntry2.getClassName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("classPK", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getClassPK(), auditEntry2.getClassPK())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getDateCreated(),
						auditEntry2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getDescription(),
						auditEntry2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("field", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getField(), auditEntry2.getField())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fieldClassName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getFieldClassName(),
						auditEntry2.getFieldClassName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fieldClassPK", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getFieldClassPK(),
						auditEntry2.getFieldClassPK())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getId(), auditEntry2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("newValue", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getNewValue(), auditEntry2.getNewValue())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("oldValue", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getOldValue(), auditEntry2.getOldValue())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getUserId(), auditEntry2.getUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditEntry1.getUserName(), auditEntry2.getUserName())) {

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
		if (!(_auditEntryResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_auditEntryResource;

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
		EntityField entityField, String operator, AuditEntry auditEntry) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("action")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getAction()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("auditSetId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("className")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getClassName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("classPK")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dateCreated")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(auditEntry.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(auditEntry.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(auditEntry.getDateCreated()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("field")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getField()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fieldClassName")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getFieldClassName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fieldClassPK")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("newValue")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getNewValue()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("oldValue")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getOldValue()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userName")) {
			sb.append("'");
			sb.append(String.valueOf(auditEntry.getUserName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected AuditEntry randomAuditEntry() throws Exception {
		return new AuditEntry() {
			{
				action = RandomTestUtil.randomString();
				auditSetId = RandomTestUtil.randomLong();
				className = RandomTestUtil.randomString();
				classPK = RandomTestUtil.randomLong();
				dateCreated = RandomTestUtil.nextDate();
				description = RandomTestUtil.randomString();
				field = RandomTestUtil.randomString();
				fieldClassName = RandomTestUtil.randomString();
				fieldClassPK = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				newValue = RandomTestUtil.randomString();
				oldValue = RandomTestUtil.randomString();
				userId = RandomTestUtil.randomLong();
				userName = RandomTestUtil.randomString();
			}
		};
	}

	protected AuditEntry randomIrrelevantAuditEntry() throws Exception {
		AuditEntry randomIrrelevantAuditEntry = randomAuditEntry();

		return randomIrrelevantAuditEntry;
	}

	protected AuditEntry randomPatchAuditEntry() throws Exception {
		return randomAuditEntry();
	}

	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseAuditEntryResourceTestCase.class);

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
		com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AuditEntryResource
			_auditEntryResource;

}