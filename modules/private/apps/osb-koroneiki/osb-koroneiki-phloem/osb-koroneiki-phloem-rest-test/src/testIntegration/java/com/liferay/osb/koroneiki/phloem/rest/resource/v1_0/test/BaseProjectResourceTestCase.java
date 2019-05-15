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
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Contact;
import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProjectSerDes;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource;
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
public abstract class BaseProjectResourceTestCase {

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
				setFilterProvider(
					new SimpleFilterProvider() {
						{
							addFilter(
								"Liferay.Vulcan",
								SimpleBeanPropertyFilter.serializeAll());
						}
					});
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		Project project1 = randomProject();

		String json = objectMapper.writeValueAsString(project1);

		Project project2 = ProjectSerDes.toDTO(json);

		Assert.assertTrue(equals(project1, project2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				setDateFormat(new ISO8601DateFormat());
				setFilterProvider(
					new SimpleFilterProvider() {
						{
							addFilter(
								"Liferay.Vulcan",
								SimpleBeanPropertyFilter.serializeAll());
						}
					});
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		Project project = randomProject();

		String json1 = objectMapper.writeValueAsString(project);
		String json2 = ProjectSerDes.toJSON(project);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testPostAccountProject() throws Exception {
		Project randomProject = randomProject();

		Project postProject = testPostAccountProject_addProject(randomProject);

		assertEquals(randomProject, postProject);
		assertValid(postProject);
	}

	protected Project testPostAccountProject_addProject(Project project)
		throws Exception {

		return invokePostAccountProject(
			testGetAccountProjectsPage_getAccountId(), project);
	}

	protected Project invokePostAccountProject(Long accountId, Project project)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ProjectSerDes.toJSON(project), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/accounts/{accountId}/projects", accountId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ProjectSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePostAccountProjectResponse(
			Long accountId, Project project)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ProjectSerDes.toJSON(project), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/accounts/{accountId}/projects", accountId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testDeleteProject() throws Exception {
		Project project = testDeleteProject_addProject();

		assertResponseCode(204, invokeDeleteProjectResponse(project.getId()));

		assertResponseCode(404, invokeGetProjectResponse(project.getId()));
	}

	protected Project testDeleteProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void invokeDeleteProject(Long projectId) throws Exception {
		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL + _toPath("/projects/{projectId}", projectId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokeDeleteProjectResponse(Long projectId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL + _toPath("/projects/{projectId}", projectId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testGetProject() throws Exception {
		Project postProject = testGetProject_addProject();

		Project getProject = invokeGetProject(postProject.getId());

		assertEquals(postProject, getProject);
		assertValid(getProject);
	}

	protected Project testGetProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Project invokeGetProject(Long projectId) throws Exception {
		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/projects/{projectId}", projectId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ProjectSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokeGetProjectResponse(Long projectId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/projects/{projectId}", projectId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testPutProject() throws Exception {
		Project postProject = testPutProject_addProject();

		Project randomProject = randomProject();

		Project putProject = invokePutProject(
			postProject.getId(), randomProject);

		assertEquals(randomProject, putProject);
		assertValid(putProject);

		Project getProject = invokeGetProject(putProject.getId());

		assertEquals(randomProject, getProject);
		assertValid(getProject);
	}

	protected Project testPutProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Project invokePutProject(Long projectId, Project project)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ProjectSerDes.toJSON(project), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/projects/{projectId}", projectId);

		options.setLocation(location);

		options.setPut(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		try {
			return ProjectSerDes.toDTO(string);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to process HTTP response: " + string, e);
			}

			throw e;
		}
	}

	protected Http.Response invokePutProjectResponse(
			Long projectId, Project project)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setBody(
			ProjectSerDes.toJSON(project), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		String location =
			_resourceURL + _toPath("/projects/{projectId}", projectId);

		options.setLocation(location);

		options.setPut(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testDeleteProjectContact() throws Exception {
		Project project = testDeleteProjectContact_addProject();

		assertResponseCode(
			204, invokeDeleteProjectContactResponse(project.getId()));

		assertResponseCode(
			404, invokeGetProjectContactResponse(project.getId()));
	}

	protected Project testDeleteProjectContact_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void invokeDeleteProjectContact(Long projectId, Long[] contactIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL + _toPath("/projects/{projectId}/contacts", projectId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokeDeleteProjectContactResponse(
			Long projectId, Long[] contactIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL + _toPath("/projects/{projectId}/contacts", projectId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testGetProjectContactsPage() throws Exception {
		Long projectId = testGetProjectContactsPage_getProjectId();
		Long irrelevantProjectId =
			testGetProjectContactsPage_getIrrelevantProjectId();

		if ((irrelevantProjectId != null)) {
			Project irrelevantProject = testGetProjectContactsPage_addProject(
				irrelevantProjectId, randomIrrelevantProject());

			Page<Project> page = invokeGetProjectContactsPage(
				irrelevantProjectId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantProject),
				(List<Project>)page.getItems());
			assertValid(page);
		}

		Project project1 = testGetProjectContactsPage_addProject(
			projectId, randomProject());

		Project project2 = testGetProjectContactsPage_addProject(
			projectId, randomProject());

		Page<Project> page = invokeGetProjectContactsPage(
			projectId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2), (List<Project>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetProjectContactsPageWithPagination() throws Exception {
		Long projectId = testGetProjectContactsPage_getProjectId();

		Project project1 = testGetProjectContactsPage_addProject(
			projectId, randomProject());

		Project project2 = testGetProjectContactsPage_addProject(
			projectId, randomProject());

		Project project3 = testGetProjectContactsPage_addProject(
			projectId, randomProject());

		Page<Project> page1 = invokeGetProjectContactsPage(
			projectId, Pagination.of(1, 2));

		List<Project> projects1 = (List<Project>)page1.getItems();

		Assert.assertEquals(projects1.toString(), 2, projects1.size());

		Page<Project> page2 = invokeGetProjectContactsPage(
			projectId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<Project> projects2 = (List<Project>)page2.getItems();

		Assert.assertEquals(projects2.toString(), 1, projects2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2, project3),
			new ArrayList<Project>() {
				{
					addAll(projects1);
					addAll(projects2);
				}
			});
	}

	protected Project testGetProjectContactsPage_addProject(
			Long projectId, Project project)
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

	protected Page<Contact> invokeGetProjectContactsPage(
			Long projectId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/projects/{projectId}/contacts", projectId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}

		return Page.of(string, ProjectSerDes::toDTO);
	}

	protected Http.Response invokeGetProjectContactsPageResponse(
			Long projectId, Pagination pagination)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/projects/{projectId}/contacts", projectId);

		location = HttpUtil.addParameter(
			location, "page", pagination.getPage());
		location = HttpUtil.addParameter(
			location, "pageSize", pagination.getPageSize());

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testPutProjectContact() throws Exception {
		Assert.assertTrue(true);
	}

	protected void invokePutProjectContact(Long projectId, Long[] contactIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/projects/{projectId}/contacts", projectId);

		options.setLocation(location);

		options.setPut(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokePutProjectContactResponse(
			Long projectId, Long[] contactIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL + _toPath("/projects/{projectId}/contacts", projectId);

		options.setLocation(location);

		options.setPut(true);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testDeleteProjectContactRole() throws Exception {
		Project project = testDeleteProjectContactRole_addProject();

		assertResponseCode(
			204, invokeDeleteProjectContactRoleResponse(project.getId()));

		assertResponseCode(
			404, invokeGetProjectContactRoleResponse(project.getId()));
	}

	protected Project testDeleteProjectContactRole_addProject()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void invokeDeleteProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL +
				_toPath(
					"/projects/{projectId}/contacts/{contactId}/roles",
					projectId, contactId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokeDeleteProjectContactRoleResponse(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL +
				_toPath(
					"/projects/{projectId}/contacts/{contactId}/roles",
					projectId, contactId);

		options.setLocation(location);

		HttpUtil.URLtoByteArray(options);

		return options.getResponse();
	}

	@Test
	public void testPutProjectContactRole() throws Exception {
		Assert.assertTrue(true);
	}

	protected void invokePutProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/projects/{projectId}/contacts/{contactId}/roles",
					projectId, contactId);

		options.setLocation(location);

		options.setPut(true);

		String string = HttpUtil.URLtoString(options);

		if (_log.isDebugEnabled()) {
			_log.debug("HTTP response: " + string);
		}
	}

	protected Http.Response invokePutProjectContactRoleResponse(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/projects/{projectId}/contacts/{contactId}/roles",
					projectId, contactId);

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

	protected void assertEquals(Project project1, Project project2) {
		Assert.assertTrue(
			project1 + " does not equal " + project2,
			equals(project1, project2));
	}

	protected void assertEquals(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (int i = 0; i < projects1.size(); i++) {
			Project project1 = projects1.get(i);
			Project project2 = projects2.get(i);

			assertEquals(project1, project2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (Project project1 : projects1) {
			boolean contains = false;

			for (Project project2 : projects2) {
				if (equals(project1, project2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				projects2 + " does not contain " + project1, contains);
		}
	}

	protected void assertValid(Project project) {
		boolean valid = true;

		if (project.getDateCreated() == null) {
			valid = false;
		}

		if (project.getDateModified() == null) {
			valid = false;
		}

		if (project.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (project.getAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (project.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("industry", additionalAssertFieldName)) {
				if (project.getIndustry() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (project.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("notes", additionalAssertFieldName)) {
				if (project.getNotes() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (project.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tier", additionalAssertFieldName)) {
				if (project.getTier() == null) {
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

	protected void assertValid(Page<Project> page) {
		boolean valid = false;

		Collection<Project> projects = page.getItems();

		int size = projects.size();

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

	protected boolean equals(Project project1, Project project2) {
		if (project1 == project2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getAccountId(), project2.getAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getCode(), project2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDateCreated(), project2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateModified", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDateModified(),
						project2.getDateModified())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(project1.getId(), project2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("industry", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getIndustry(), project2.getIndustry())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getName(), project2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("notes", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getNotes(), project2.getNotes())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getStatus(), project2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tier", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getTier(), project2.getTier())) {

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
		if (!(_projectResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_projectResource;

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
		EntityField entityField, String operator, Project project) {

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

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(project.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("dateCreated")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getDateCreated()));
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
						DateUtils.addSeconds(project.getDateModified(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateModified(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getDateModified()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("industry")) {
			sb.append("'");
			sb.append(String.valueOf(project.getIndustry()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(project.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("notes")) {
			sb.append("'");
			sb.append(String.valueOf(project.getNotes()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			sb.append("'");
			sb.append(String.valueOf(project.getStatus()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("tier")) {
			sb.append("'");
			sb.append(String.valueOf(project.getTier()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Project randomProject() {
		return new Project() {
			{
				accountId = RandomTestUtil.randomLong();
				code = RandomTestUtil.randomString();
				dateCreated = RandomTestUtil.nextDate();
				dateModified = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				industry = RandomTestUtil.randomString();
				name = RandomTestUtil.randomString();
				notes = RandomTestUtil.randomString();
				status = RandomTestUtil.randomString();
				tier = RandomTestUtil.randomString();
			}
		};
	}

	protected Project randomIrrelevantProject() {
		Project randomIrrelevantProject = randomProject();

		return randomIrrelevantProject;
	}

	protected Project randomPatchProject() {
		return randomProject();
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
		BaseProjectResourceTestCase.class);

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
	private ProjectResource _projectResource;

	private URL _resourceURL;

}