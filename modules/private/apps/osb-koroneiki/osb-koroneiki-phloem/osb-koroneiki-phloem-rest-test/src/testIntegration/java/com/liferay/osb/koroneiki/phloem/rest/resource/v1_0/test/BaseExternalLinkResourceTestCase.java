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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ExternalLinkSerDes;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ExternalLinkResource;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.net.URL;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

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

		_resourceURL = new URL("http://localhost:8080/o/koroneiki-rest/v1.0");
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
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
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
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		ExternalLink externalLink = randomExternalLink();

		String json1 = objectMapper.writeValueAsString(externalLink);
		String json2 = ExternalLinkSerDes.toJSON(externalLink);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
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

			Page<ExternalLink> page = invokeGetAccountExternalLinksPage(
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

		Page<ExternalLink> page = invokeGetAccountExternalLinksPage(
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

		Page<ExternalLink> page1 = invokeGetAccountExternalLinksPage(
			accountId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 = invokeGetAccountExternalLinksPage(
			accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			new ArrayList<ExternalLink>() {
				{
					addAll(externalLinks1);
					addAll(externalLinks2);
				}
			});
	}

	protected ExternalLink testGetAccountExternalLinksPage_addExternalLink(
			Long accountId, ExternalLink externalLink)
		throws Exception {

		return invokePostAccountExternalLink(accountId, externalLink);
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

	protected Page<ExternalLink> invokeGetAccountExternalLinksPage(
			Long accountId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/accounts/{accountId}/external-links", accountId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		return Page.of(string, ExternalLinkSerDes::toDTO);
	}

	protected Http.Response invokeGetAccountExternalLinksPageResponse(
			Long accountId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/accounts/{accountId}/external-links", accountId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

		return invokePostAccountExternalLink(
			testGetAccountExternalLinksPage_getAccountId(), externalLink);
	}

	protected ExternalLink invokePostAccountExternalLink(
			Long accountId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL +
				_toPath("/accounts/{accountId}/external-links", accountId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ExternalLinkSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePostAccountExternalLinkResponse(
			Long accountId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL +
				_toPath("/accounts/{accountId}/external-links", accountId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

			Page<ExternalLink> page = invokeGetContactExternalLinksPage(
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

		Page<ExternalLink> page = invokeGetContactExternalLinksPage(
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

		Page<ExternalLink> page1 = invokeGetContactExternalLinksPage(
			contactId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 = invokeGetContactExternalLinksPage(
			contactId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			new ArrayList<ExternalLink>() {
				{
					addAll(externalLinks1);
					addAll(externalLinks2);
				}
			});
	}

	protected ExternalLink testGetContactExternalLinksPage_addExternalLink(
			Long contactId, ExternalLink externalLink)
		throws Exception {

		return invokePostContactExternalLink(contactId, externalLink);
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

	protected Page<ExternalLink> invokeGetContactExternalLinksPage(
			Long contactId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/contacts/{contactId}/external-links", contactId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		return Page.of(string, ExternalLinkSerDes::toDTO);
	}

	protected Http.Response invokeGetContactExternalLinksPageResponse(
			Long contactId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/contacts/{contactId}/external-links", contactId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

		return invokePostContactExternalLink(
			testGetContactExternalLinksPage_getContactId(), externalLink);
	}

	protected ExternalLink invokePostContactExternalLink(
			Long contactId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL +
				_toPath("/contacts/{contactId}/external-links", contactId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ExternalLinkSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePostContactExternalLinkResponse(
			Long contactId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL +
				_toPath("/contacts/{contactId}/external-links", contactId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testDeleteExternalLink() throws Exception {
		ExternalLink externalLink = testDeleteExternalLink_addExternalLink();

		assertResponseCode(
			204, invokeDeleteExternalLinkResponse(externalLink.getId()));

		assertResponseCode(
			404, invokeGetExternalLinkResponse(externalLink.getId()));

		assertResponseCode(404, invokeGetExternalLinkResponse(0L));
	}

	protected ExternalLink testDeleteExternalLink_addExternalLink()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void invokeDeleteExternalLink(Long externalLinkId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL +
				_toPath("/external-links/{externalLinkId}", externalLinkId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokeDeleteExternalLinkResponse(
			Long externalLinkId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL +
				_toPath("/external-links/{externalLinkId}", externalLinkId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testGetExternalLink() throws Exception {
		ExternalLink postExternalLink = testGetExternalLink_addExternalLink();

		ExternalLink getExternalLink = invokeGetExternalLink(
			postExternalLink.getId());

		assertEquals(postExternalLink, getExternalLink);
		assertValid(getExternalLink);
	}

	protected ExternalLink testGetExternalLink_addExternalLink()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected ExternalLink invokeGetExternalLink(Long externalLinkId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/external-links/{externalLinkId}", externalLinkId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ExternalLinkSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokeGetExternalLinkResponse(Long externalLinkId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/external-links/{externalLinkId}", externalLinkId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

			Page<ExternalLink> page = invokeGetProjectExternalLinksPage(
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

		Page<ExternalLink> page = invokeGetProjectExternalLinksPage(
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

		Page<ExternalLink> page1 = invokeGetProjectExternalLinksPage(
			projectId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 = invokeGetProjectExternalLinksPage(
			projectId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			new ArrayList<ExternalLink>() {
				{
					addAll(externalLinks1);
					addAll(externalLinks2);
				}
			});
	}

	protected ExternalLink testGetProjectExternalLinksPage_addExternalLink(
			Long projectId, ExternalLink externalLink)
		throws Exception {

		return invokePostProjectExternalLink(projectId, externalLink);
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

	protected Page<ExternalLink> invokeGetProjectExternalLinksPage(
			Long projectId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/projects/{projectId}/external-links", projectId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		return Page.of(string, ExternalLinkSerDes::toDTO);
	}

	protected Http.Response invokeGetProjectExternalLinksPageResponse(
			Long projectId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath("/projects/{projectId}/external-links", projectId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

		return invokePostProjectExternalLink(
			testGetProjectExternalLinksPage_getProjectId(), externalLink);
	}

	protected ExternalLink invokePostProjectExternalLink(
			Long projectId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL +
				_toPath("/projects/{projectId}/external-links", projectId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ExternalLinkSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePostProjectExternalLinkResponse(
			Long projectId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL +
				_toPath("/projects/{projectId}/external-links", projectId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

			Page<ExternalLink> page = invokeGetTeamExternalLinksPage(
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

		Page<ExternalLink> page = invokeGetTeamExternalLinksPage(
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

		Page<ExternalLink> page1 = invokeGetTeamExternalLinksPage(
			teamId, Pagination.of(1, 2));

		List<ExternalLink> externalLinks1 =
			(List<ExternalLink>)page1.getItems();

		Assert.assertEquals(
			externalLinks1.toString(), 2, externalLinks1.size());

		Page<ExternalLink> page2 = invokeGetTeamExternalLinksPage(
			teamId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ExternalLink> externalLinks2 =
			(List<ExternalLink>)page2.getItems();

		Assert.assertEquals(
			externalLinks2.toString(), 1, externalLinks2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(externalLink1, externalLink2, externalLink3),
			new ArrayList<ExternalLink>() {
				{
					addAll(externalLinks1);
					addAll(externalLinks2);
				}
			});
	}

	protected ExternalLink testGetTeamExternalLinksPage_addExternalLink(
			Long teamId, ExternalLink externalLink)
		throws Exception {

		return invokePostTeamExternalLink(teamId, externalLink);
	}

	protected Long testGetTeamExternalLinksPage_getTeamId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTeamExternalLinksPage_getIrrelevantTeamId()
		throws Exception {

		return null;
	}

	protected Page<ExternalLink> invokeGetTeamExternalLinksPage(
			Long teamId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/teams/{teamId}/external-links", teamId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		return Page.of(string, ExternalLinkSerDes::toDTO);
	}

	protected Http.Response invokeGetTeamExternalLinksPageResponse(
			Long teamId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/teams/{teamId}/external-links", teamId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
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

		return invokePostTeamExternalLink(
			testGetTeamExternalLinksPage_getTeamId(), externalLink);
	}

	protected ExternalLink invokePostTeamExternalLink(
			Long teamId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/teams/{teamId}/external-links", teamId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ExternalLinkSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePostTeamExternalLinkResponse(
			Long teamId, ExternalLink externalLink)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ExternalLinkSerDes.toJSON(externalLink),
			ContentTypes.APPLICATION_JSON, StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/teams/{teamId}/external-links", teamId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	protected void assertResponseCode(
		int expectedResponseCode, Http.Response actualResponse) {

		Assert.assertEquals(
			expectedResponseCode, actualResponse.getResponseCode());
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
	protected String testContentType = "application/json";
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private Http.Options _createHttpOptions() {
		Http.Options options = new Http.Options();

		options.addHeader("Accept", "application/json");
		options.addHeader(
			"Accept-Language", LocaleUtil.toW3cLanguageId(testLocale));

		String encodedTestUserNameAndPassword = Base64.encode(
			testUserNameAndPassword.getBytes());

		options.addHeader(
			"Authorization", "Basic " + encodedTestUserNameAndPassword);

		options.addHeader("Content-Type", testContentType);

		return options;
	}

	private String _toJSON(Map<String, String> map) {
		if (map == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		Set<Map.Entry<String, String>> set = map.entrySet();

		Iterator<Map.Entry<String, String>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();

			sb.append("\"" + entry.getKey() + "\": ");

			if (entry.getValue() == null) {
				sb.append("null");
			}
			else {
				sb.append("\"" + entry.getValue() + "\"");
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private String _toPath(String template, Object... values) {
		if (ArrayUtil.isEmpty(values)) {
			return template;
		}

		for (int i = 0; i < values.length; i++) {
			template = template.replaceFirst(
				"\\{.*?\\}", String.valueOf(values[i]));
		}

		return template;
	}

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
	private ExternalLinkResource _externalLinkResource;

	private URL _resourceURL;

}