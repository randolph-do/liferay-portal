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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.ExternalLinkResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ExternalLinkSerDes;
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
public abstract class BaseExternalLinkResourceTestCase {

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

		_externalLinkResource.setContextCompany(testCompany);
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

		ExternalLink externalLink1 = randomExternalLink();

		String json = objectMapper.writeValueAsString(externalLink1);

		ExternalLink externalLink2 = ExternalLinkSerDes.toDTO(json);

		Assert.assertTrue(equals(externalLink1, externalLink2));
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

		ExternalLink externalLink = randomExternalLink();

		String json1 = objectMapper.writeValueAsString(externalLink);
		String json2 = ExternalLinkSerDes.toJSON(externalLink);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ExternalLink externalLink = randomExternalLink();

		externalLink.setDomain(regex);
		externalLink.setEntityId(regex);
		externalLink.setEntityName(regex);

		String json = ExternalLinkSerDes.toJSON(externalLink);

		Assert.assertFalse(json.contains(regex));

		externalLink = ExternalLinkSerDes.toDTO(json);

		Assert.assertEquals(regex, externalLink.getDomain());
		Assert.assertEquals(regex, externalLink.getEntityId());
		Assert.assertEquals(regex, externalLink.getEntityName());
	}

	@Test
	public void testGetAccountExternalLinksPage() throws Exception {
		Long accountId = testGetAccountExternalLinksPage_getAccountId();
		Long irrelevantAccountId =
			testGetAccountExternalLinksPage_getIrrelevantAccountId();

		if ((irrelevantAccountId != null)) {
			ExternalLink irrelevantExternalLink =
				testGetAccountExternalLinksPage_addExternalLink(
					irrelevantAccountId, randomIrrelevantExternalLink());

			Page<ExternalLink> page =
				ExternalLinkResource.getAccountExternalLinksPage(
					irrelevantAccountId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantExternalLink),
				(List<ExternalLink>)page.getItems());
			assertValid(page);
		}

		ExternalLink externalLink1 =
			testGetAccountExternalLinksPage_addExternalLink(
				accountId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetAccountExternalLinksPage_addExternalLink(
				accountId, randomExternalLink());

		Page<ExternalLink> page =
			ExternalLinkResource.getAccountExternalLinksPage(
				accountId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2),
			(List<ExternalLink>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountExternalLinksPageWithPagination()
		throws Exception {

		Long accountId = testGetAccountExternalLinksPage_getAccountId();

		ExternalLink externalLink1 =
			testGetAccountExternalLinksPage_addExternalLink(
				accountId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetAccountExternalLinksPage_addExternalLink(
				accountId, randomExternalLink());

		ExternalLink externalLink3 =
			testGetAccountExternalLinksPage_addExternalLink(
				accountId, randomExternalLink());

		Page<ExternalLink> page1 =
			ExternalLinkResource.getAccountExternalLinksPage(
				accountId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 =
			ExternalLinkResource.getAccountExternalLinksPage(
				accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		Page<ExternalLink> page3 =
			ExternalLinkResource.getAccountExternalLinksPage(
				accountId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			(List<ExternalLink>)page3.getItems());
	}

	protected ExternalLink testGetAccountExternalLinksPage_addExternalLink(
			Long accountId, ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postAccountExternalLink(
			accountId, externalLink);
	}

	protected Long testGetAccountExternalLinksPage_getAccountId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountExternalLinksPage_getIrrelevantAccountId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostAccountExternalLink() throws Exception {
		ExternalLink randomExternalLink = randomExternalLink();

		ExternalLink postExternalLink =
			testPostAccountExternalLink_addExternalLink(randomExternalLink);

		assertEquals(randomExternalLink, postExternalLink);
		assertValid(postExternalLink);
	}

	protected ExternalLink testPostAccountExternalLink_addExternalLink(
			ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postAccountExternalLink(
			testGetAccountExternalLinksPage_getAccountId(), externalLink);
	}

	@Test
	public void testGetContactExternalLinksPage() throws Exception {
		Long contactId = testGetContactExternalLinksPage_getContactId();
		Long irrelevantContactId =
			testGetContactExternalLinksPage_getIrrelevantContactId();

		if ((irrelevantContactId != null)) {
			ExternalLink irrelevantExternalLink =
				testGetContactExternalLinksPage_addExternalLink(
					irrelevantContactId, randomIrrelevantExternalLink());

			Page<ExternalLink> page =
				ExternalLinkResource.getContactExternalLinksPage(
					irrelevantContactId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantExternalLink),
				(List<ExternalLink>)page.getItems());
			assertValid(page);
		}

		ExternalLink externalLink1 =
			testGetContactExternalLinksPage_addExternalLink(
				contactId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetContactExternalLinksPage_addExternalLink(
				contactId, randomExternalLink());

		Page<ExternalLink> page =
			ExternalLinkResource.getContactExternalLinksPage(
				contactId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2),
			(List<ExternalLink>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetContactExternalLinksPageWithPagination()
		throws Exception {

		Long contactId = testGetContactExternalLinksPage_getContactId();

		ExternalLink externalLink1 =
			testGetContactExternalLinksPage_addExternalLink(
				contactId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetContactExternalLinksPage_addExternalLink(
				contactId, randomExternalLink());

		ExternalLink externalLink3 =
			testGetContactExternalLinksPage_addExternalLink(
				contactId, randomExternalLink());

		Page<ExternalLink> page1 =
			ExternalLinkResource.getContactExternalLinksPage(
				contactId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 =
			ExternalLinkResource.getContactExternalLinksPage(
				contactId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		Page<ExternalLink> page3 =
			ExternalLinkResource.getContactExternalLinksPage(
				contactId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			(List<ExternalLink>)page3.getItems());
	}

	protected ExternalLink testGetContactExternalLinksPage_addExternalLink(
			Long contactId, ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postContactExternalLink(
			contactId, externalLink);
	}

	protected Long testGetContactExternalLinksPage_getContactId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetContactExternalLinksPage_getIrrelevantContactId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostContactExternalLink() throws Exception {
		ExternalLink randomExternalLink = randomExternalLink();

		ExternalLink postExternalLink =
			testPostContactExternalLink_addExternalLink(randomExternalLink);

		assertEquals(randomExternalLink, postExternalLink);
		assertValid(postExternalLink);
	}

	protected ExternalLink testPostContactExternalLink_addExternalLink(
			ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postContactExternalLink(
			testGetContactExternalLinksPage_getContactId(), externalLink);
	}

	@Test
	public void testDeleteExternalLink() throws Exception {
		ExternalLink externalLink = testDeleteExternalLink_addExternalLink();

		assertHttpResponseStatusCode(
			204,
			ExternalLinkResource.deleteExternalLinkHttpResponse(
				externalLink.getId()));

		assertHttpResponseStatusCode(
			404,
			ExternalLinkResource.getExternalLinkHttpResponse(
				externalLink.getId()));

		assertHttpResponseStatusCode(
			404, ExternalLinkResource.getExternalLinkHttpResponse(0L));
	}

	protected ExternalLink testDeleteExternalLink_addExternalLink()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetExternalLink() throws Exception {
		ExternalLink postExternalLink = testGetExternalLink_addExternalLink();

		ExternalLink getExternalLink = ExternalLinkResource.getExternalLink(
			postExternalLink.getId());

		assertEquals(postExternalLink, getExternalLink);
		assertValid(getExternalLink);
	}

	protected ExternalLink testGetExternalLink_addExternalLink()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProjectExternalLinksPage() throws Exception {
		Long projectId = testGetProjectExternalLinksPage_getProjectId();
		Long irrelevantProjectId =
			testGetProjectExternalLinksPage_getIrrelevantProjectId();

		if ((irrelevantProjectId != null)) {
			ExternalLink irrelevantExternalLink =
				testGetProjectExternalLinksPage_addExternalLink(
					irrelevantProjectId, randomIrrelevantExternalLink());

			Page<ExternalLink> page =
				ExternalLinkResource.getProjectExternalLinksPage(
					irrelevantProjectId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantExternalLink),
				(List<ExternalLink>)page.getItems());
			assertValid(page);
		}

		ExternalLink externalLink1 =
			testGetProjectExternalLinksPage_addExternalLink(
				projectId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetProjectExternalLinksPage_addExternalLink(
				projectId, randomExternalLink());

		Page<ExternalLink> page =
			ExternalLinkResource.getProjectExternalLinksPage(
				projectId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2),
			(List<ExternalLink>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetProjectExternalLinksPageWithPagination()
		throws Exception {

		Long projectId = testGetProjectExternalLinksPage_getProjectId();

		ExternalLink externalLink1 =
			testGetProjectExternalLinksPage_addExternalLink(
				projectId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetProjectExternalLinksPage_addExternalLink(
				projectId, randomExternalLink());

		ExternalLink externalLink3 =
			testGetProjectExternalLinksPage_addExternalLink(
				projectId, randomExternalLink());

		Page<ExternalLink> page1 =
			ExternalLinkResource.getProjectExternalLinksPage(
				projectId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 =
			ExternalLinkResource.getProjectExternalLinksPage(
				projectId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		Page<ExternalLink> page3 =
			ExternalLinkResource.getProjectExternalLinksPage(
				projectId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			(List<ExternalLink>)page3.getItems());
	}

	protected ExternalLink testGetProjectExternalLinksPage_addExternalLink(
			Long projectId, ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postProjectExternalLink(
			projectId, externalLink);
	}

	protected Long testGetProjectExternalLinksPage_getProjectId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetProjectExternalLinksPage_getIrrelevantProjectId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostProjectExternalLink() throws Exception {
		ExternalLink randomExternalLink = randomExternalLink();

		ExternalLink postExternalLink =
			testPostProjectExternalLink_addExternalLink(randomExternalLink);

		assertEquals(randomExternalLink, postExternalLink);
		assertValid(postExternalLink);
	}

	protected ExternalLink testPostProjectExternalLink_addExternalLink(
			ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postProjectExternalLink(
			testGetProjectExternalLinksPage_getProjectId(), externalLink);
	}

	@Test
	public void testGetTeamExternalLinksPage() throws Exception {
		Long teamId = testGetTeamExternalLinksPage_getTeamId();
		Long irrelevantTeamId =
			testGetTeamExternalLinksPage_getIrrelevantTeamId();

		if ((irrelevantTeamId != null)) {
			ExternalLink irrelevantExternalLink =
				testGetTeamExternalLinksPage_addExternalLink(
					irrelevantTeamId, randomIrrelevantExternalLink());

			Page<ExternalLink> page =
				ExternalLinkResource.getTeamExternalLinksPage(
					irrelevantTeamId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantExternalLink),
				(List<ExternalLink>)page.getItems());
			assertValid(page);
		}

		ExternalLink externalLink1 =
			testGetTeamExternalLinksPage_addExternalLink(
				teamId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetTeamExternalLinksPage_addExternalLink(
				teamId, randomExternalLink());

		Page<ExternalLink> page = ExternalLinkResource.getTeamExternalLinksPage(
			teamId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2),
			(List<ExternalLink>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTeamExternalLinksPageWithPagination() throws Exception {
		Long teamId = testGetTeamExternalLinksPage_getTeamId();

		ExternalLink externalLink1 =
			testGetTeamExternalLinksPage_addExternalLink(
				teamId, randomExternalLink());

		ExternalLink externalLink2 =
			testGetTeamExternalLinksPage_addExternalLink(
				teamId, randomExternalLink());

		ExternalLink externalLink3 =
			testGetTeamExternalLinksPage_addExternalLink(
				teamId, randomExternalLink());

		Page<ExternalLink> page1 =
			ExternalLinkResource.getTeamExternalLinksPage(
				teamId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 =
			ExternalLinkResource.getTeamExternalLinksPage(
				teamId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		Page<ExternalLink> page3 =
			ExternalLinkResource.getTeamExternalLinksPage(
				teamId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			(List<ExternalLink>)page3.getItems());
	}

	protected ExternalLink testGetTeamExternalLinksPage_addExternalLink(
			Long teamId, ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postTeamExternalLink(teamId, externalLink);
	}

	protected Long testGetTeamExternalLinksPage_getTeamId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTeamExternalLinksPage_getIrrelevantTeamId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostTeamExternalLink() throws Exception {
		ExternalLink randomExternalLink = randomExternalLink();

		ExternalLink postExternalLink =
			testPostTeamExternalLink_addExternalLink(randomExternalLink);

		assertEquals(randomExternalLink, postExternalLink);
		assertValid(postExternalLink);
	}

	protected ExternalLink testPostTeamExternalLink_addExternalLink(
			ExternalLink externalLink)
		throws Exception {

		return ExternalLinkResource.postTeamExternalLink(
			testGetTeamExternalLinksPage_getTeamId(), externalLink);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ExternalLink externalLink1, ExternalLink externalLink2) {

		Assert.assertTrue(
			externalLink1 + " does not equal " + externalLink2,
			equals(externalLink1, externalLink2));
	}

	protected void assertEquals(
		List<ExternalLink> externalLinks1, List<ExternalLink> externalLinks2) {

		Assert.assertEquals(externalLinks1.size(), externalLinks2.size());

		for (int i = 0; i < externalLinks1.size(); i++) {
			ExternalLink externalLink1 = externalLinks1.get(i);
			ExternalLink externalLink2 = externalLinks2.get(i);

			assertEquals(externalLink1, externalLink2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ExternalLink> externalLinks1, List<ExternalLink> externalLinks2) {

		Assert.assertEquals(externalLinks1.size(), externalLinks2.size());

		for (ExternalLink externalLink1 : externalLinks1) {
			boolean contains = false;

			for (ExternalLink externalLink2 : externalLinks2) {
				if (equals(externalLink1, externalLink2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				externalLinks2 + " does not contain " + externalLink1,
				contains);
		}
	}

	protected void assertValid(ExternalLink externalLink) {
		boolean valid = true;

		if (externalLink.getDateCreated() == null) {
			valid = false;
		}

		if (externalLink.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("domain", additionalAssertFieldName)) {
				if (externalLink.getDomain() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("entityId", additionalAssertFieldName)) {
				if (externalLink.getEntityId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("entityName", additionalAssertFieldName)) {
				if (externalLink.getEntityName() == null) {
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

	protected void assertValid(Page<ExternalLink> page) {
		boolean valid = false;

		Collection<ExternalLink> externalLinks = page.getItems();

		int size = externalLinks.size();

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

	protected boolean equals(
		ExternalLink externalLink1, ExternalLink externalLink2) {

		if (externalLink1 == externalLink2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						externalLink1.getDateCreated(),
						externalLink2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("domain", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						externalLink1.getDomain(), externalLink2.getDomain())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("entityId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						externalLink1.getEntityId(),
						externalLink2.getEntityId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("entityName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						externalLink1.getEntityName(),
						externalLink2.getEntityName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						externalLink1.getId(), externalLink2.getId())) {

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
		if (!(_externalLinkResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_externalLinkResource;

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
		EntityField entityField, String operator, ExternalLink externalLink) {

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
							externalLink.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							externalLink.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(externalLink.getDateCreated()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("domain")) {
			sb.append("'");
			sb.append(String.valueOf(externalLink.getDomain()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("entityId")) {
			sb.append("'");
			sb.append(String.valueOf(externalLink.getEntityId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("entityName")) {
			sb.append("'");
			sb.append(String.valueOf(externalLink.getEntityName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected ExternalLink randomExternalLink() throws Exception {
		return new ExternalLink() {
			{
				dateCreated = RandomTestUtil.nextDate();
				domain = RandomTestUtil.randomString();
				entityId = RandomTestUtil.randomString();
				entityName = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
			}
		};
	}

	protected ExternalLink randomIrrelevantExternalLink() throws Exception {
		ExternalLink randomIrrelevantExternalLink = randomExternalLink();

		return randomIrrelevantExternalLink;
	}

	protected ExternalLink randomPatchExternalLink() throws Exception {
		return randomExternalLink();
	}

	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseExternalLinkResourceTestCase.class);

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
		com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ExternalLinkResource
			_externalLinkResource;

}