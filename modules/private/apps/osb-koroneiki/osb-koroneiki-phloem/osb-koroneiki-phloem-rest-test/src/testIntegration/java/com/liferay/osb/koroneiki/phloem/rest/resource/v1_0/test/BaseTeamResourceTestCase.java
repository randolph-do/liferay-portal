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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Team;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.TeamSerDes;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.TeamResource;
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
public abstract class BaseTeamResourceTestCase {

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

		Team team1 = randomTeam();

		String json = objectMapper.writeValueAsString(team1);

		Team team2 = TeamSerDes.toDTO(json);

		Assert.assertTrue(equals(team1, team2));
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

		Team team = randomTeam();

		String json1 = objectMapper.writeValueAsString(team);
		String json2 = TeamSerDes.toJSON(team);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetAccountTeamsPage() throws Exception {
		Long accountId = testGetAccountTeamsPage_getAccountId();
		Long irrelevantAccountId =
			testGetAccountTeamsPage_getIrrelevantAccountId();

		if ((irrelevantAccountId != null)) {
			Team irrelevantTeam = testGetAccountTeamsPage_addTeam(
				irrelevantAccountId, randomIrrelevantTeam());

			Page<Team> page = invokeGetAccountTeamsPage(
				irrelevantAccountId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantTeam), (List<Team>)page.getItems());
			assertValid(page);
		}

		Team team1 = testGetAccountTeamsPage_addTeam(accountId, randomTeam());

		Team team2 = testGetAccountTeamsPage_addTeam(accountId, randomTeam());

		Page<Team> page = invokeGetAccountTeamsPage(
			accountId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(team1, team2), (List<Team>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountTeamsPageWithPagination() throws Exception {
		Long accountId = testGetAccountTeamsPage_getAccountId();

		Team team1 = testGetAccountTeamsPage_addTeam(accountId, randomTeam());

		Team team2 = testGetAccountTeamsPage_addTeam(accountId, randomTeam());

		Team team3 = testGetAccountTeamsPage_addTeam(accountId, randomTeam());

		Page<Team> page1 = invokeGetAccountTeamsPage(
			accountId, Pagination.of(1, 2));

		List<Team> teams1 = (List<Team>)page1.getItems();

		Assert.assertEquals(teams1.toString(), 2, teams1.size());

		Page<Team> page2 = invokeGetAccountTeamsPage(
			accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<Team> teams2 = (List<Team>)page2.getItems();

		Assert.assertEquals(teams2.toString(), 1, teams2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(team1, team2, team3),
			new ArrayList<Team>() {
				{
					addAll(teams1);
					addAll(teams2);
				}
			});
	}

	protected Team testGetAccountTeamsPage_addTeam(Long accountId, Team team)
		throws Exception {

		return invokePostAccountTeam(accountId, team);
	}

	protected Long testGetAccountTeamsPage_getAccountId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountTeamsPage_getIrrelevantAccountId()
		throws Exception {

		return null;
	}

	protected Page<Team> invokeGetAccountTeamsPage(
			Long accountId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/accounts/{accountId}/teams", accountId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		return Page.of(string, TeamSerDes::toDTO);
	}

	protected Http.Response invokeGetAccountTeamsPageResponse(
			Long accountId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/accounts/{accountId}/teams", accountId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testPostAccountTeam() throws Exception {
		Team randomTeam = randomTeam();

		Team postTeam = testPostAccountTeam_addTeam(randomTeam);

		assertEquals(randomTeam, postTeam);
		assertValid(postTeam);
	}

	protected Team testPostAccountTeam_addTeam(Team team) throws Exception {
		return invokePostAccountTeam(
			testGetAccountTeamsPage_getAccountId(), team);
	}

	protected Team invokePostAccountTeam(Long accountId, Team team)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			TeamSerDes.toJSON(team), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/accounts/{accountId}/teams", accountId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return TeamSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePostAccountTeamResponse(
			Long accountId, Team team)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			TeamSerDes.toJSON(team), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/accounts/{accountId}/teams", accountId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testDeleteTeam() throws Exception {
		Team team = testDeleteTeam_addTeam();

		assertResponseCode(204, invokeDeleteTeamResponse(team.getId()));

		assertResponseCode(404, invokeGetTeamResponse(team.getId()));

		assertResponseCode(404, invokeGetTeamResponse(0L));
	}

	protected Team testDeleteTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void invokeDeleteTeam(Long teamId) throws Exception {
		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location = _resourceURL + _toPath("/teams/{teamId}", teamId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokeDeleteTeamResponse(Long teamId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location = _resourceURL + _toPath("/teams/{teamId}", teamId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testGetTeam() throws Exception {
		Team postTeam = testGetTeam_addTeam();

		Team getTeam = invokeGetTeam(postTeam.getId());

		assertEquals(postTeam, getTeam);
		assertValid(getTeam);
	}

	protected Team testGetTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Team invokeGetTeam(Long teamId) throws Exception {
		Http.Options options = _createHttpOptions();

		String location = _resourceURL + _toPath("/teams/{teamId}", teamId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return TeamSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokeGetTeamResponse(Long teamId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location = _resourceURL + _toPath("/teams/{teamId}", teamId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testPutTeam() throws Exception {
		Team postTeam = testPutTeam_addTeam();

		Team randomTeam = randomTeam();

		Team putTeam = invokePutTeam(postTeam.getId(), randomTeam);

		assertEquals(randomTeam, putTeam);
		assertValid(putTeam);

		Team getTeam = invokeGetTeam(putTeam.getId());

		assertEquals(randomTeam, getTeam);
		assertValid(getTeam);
	}

	protected Team testPutTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Team invokePutTeam(Long teamId, Team team) throws Exception {
		Http.Options options = _createHttpOptions();

		options.setBody(
			TeamSerDes.toJSON(team), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location = _resourceURL + _toPath("/teams/{teamId}", teamId);

		options.setLocation(location);

		options.setPut(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return TeamSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePutTeamResponse(Long teamId, Team team)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			TeamSerDes.toJSON(team), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location = _resourceURL + _toPath("/teams/{teamId}", teamId);

		options.setLocation(location);

		options.setPut(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	protected void assertResponseCode(
		int expectedResponseCode, Http.Response actualResponse) {

		Assert.assertEquals(
			expectedResponseCode, actualResponse.getResponseCode());
	}

	protected void assertEquals(Team team1, Team team2) {
		Assert.assertTrue(
			team1 + " does not equal " + team2, equals(team1, team2));
	}

	protected void assertEquals(List<Team> teams1, List<Team> teams2) {
		Assert.assertEquals(teams1.size(), teams2.size());

		for (int i = 0; i < teams1.size(); i++) {
			Team team1 = teams1.get(i);
			Team team2 = teams2.get(i);

			assertEquals(team1, team2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Team> teams1, List<Team> teams2) {

		Assert.assertEquals(teams1.size(), teams2.size());

		for (Team team1 : teams1) {
			boolean contains = false;

			for (Team team2 : teams2) {
				if (equals(team1, team2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(teams2 + " does not contain " + team1, contains);
		}
	}

	protected void assertValid(Team team) {
		boolean valid = true;

		if (team.getDateCreated() == null) {
			valid = false;
		}

		if (team.getDateModified() == null) {
			valid = false;
		}

		if (team.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (team.getAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (team.getExternalLinks() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (team.getName() == null) {
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

	protected void assertValid(Page<Team> page) {
		boolean valid = false;

		Collection<Team> teams = page.getItems();

		int size = teams.size();

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

	protected boolean equals(Team team1, Team team2) {
		if (team1 == team2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getAccountId(), team2.getAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getDateCreated(), team2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateModified", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getDateModified(), team2.getDateModified())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getExternalLinks(), team2.getExternalLinks())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(team1.getId(), team2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(team1.getName(), team2.getName())) {
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
		if (!(_teamResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_teamResource;

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
		EntityField entityField, String operator, Team team) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountId")) {
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
						DateUtils.addSeconds(team.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(team.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(team.getDateCreated()));
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
						DateUtils.addSeconds(team.getDateModified(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(team.getDateModified(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(team.getDateModified()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("externalLinks")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(team.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Team randomTeam() throws Exception {
		return new Team() {
			{
				accountId = RandomTestUtil.randomLong();
				dateCreated = RandomTestUtil.nextDate();
				dateModified = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				name = RandomTestUtil.randomString();
			}
		};
	}

	protected Team randomIrrelevantTeam() throws Exception {
		Team randomIrrelevantTeam = randomTeam();

		return randomIrrelevantTeam;
	}

	protected Team randomPatchTeam() throws Exception {
		return randomTeam();
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
		BaseTeamResourceTestCase.class);

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
	private TeamResource _teamResource;

	private URL _resourceURL;

}