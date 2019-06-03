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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.ProjectResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProjectSerDes;
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

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_projectResource.setContextCompany(testCompany);
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

		Project project = randomProject();

		String json1 = objectMapper.writeValueAsString(project);
		String json2 = ProjectSerDes.toJSON(project);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Project project = randomProject();

		project.setCode(regex);
		project.setIndustry(regex);
		project.setName(regex);
		project.setNotes(regex);
		project.setStatus(regex);
		project.setTier(regex);

		String json = ProjectSerDes.toJSON(project);

		Assert.assertFalse(json.contains(regex));

		project = ProjectSerDes.toDTO(json);

		Assert.assertEquals(regex, project.getCode());
		Assert.assertEquals(regex, project.getIndustry());
		Assert.assertEquals(regex, project.getName());
		Assert.assertEquals(regex, project.getNotes());
		Assert.assertEquals(regex, project.getStatus());
		Assert.assertEquals(regex, project.getTier());
	}

	@Test
	public void testGetAccountProjectsPage() throws Exception {
		Long accountId = testGetAccountProjectsPage_getAccountId();
		Long irrelevantAccountId =
			testGetAccountProjectsPage_getIrrelevantAccountId();

		if ((irrelevantAccountId != null)) {
			Project irrelevantProject = testGetAccountProjectsPage_addProject(
				irrelevantAccountId, randomIrrelevantProject());

			Page<Project> page = ProjectResource.getAccountProjectsPage(
				irrelevantAccountId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantProject),
				(List<Project>)page.getItems());
			assertValid(page);
		}

		Project project1 = testGetAccountProjectsPage_addProject(
			accountId, randomProject());

		Project project2 = testGetAccountProjectsPage_addProject(
			accountId, randomProject());

		Page<Project> page = ProjectResource.getAccountProjectsPage(
			accountId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2), (List<Project>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountProjectsPageWithPagination() throws Exception {
		Long accountId = testGetAccountProjectsPage_getAccountId();

		Project project1 = testGetAccountProjectsPage_addProject(
			accountId, randomProject());

		Project project2 = testGetAccountProjectsPage_addProject(
			accountId, randomProject());

		Project project3 = testGetAccountProjectsPage_addProject(
			accountId, randomProject());

		Page<Project> page1 = ProjectResource.getAccountProjectsPage(
			accountId, Pagination.of(1, 2));

		List<Project> projects1 = (List<Project>)page1.getItems();

		Assert.assertEquals(projects1.toString(), 2, projects1.size());

		Page<Project> page2 = ProjectResource.getAccountProjectsPage(
			accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<Project> projects2 = (List<Project>)page2.getItems();

		Assert.assertEquals(projects2.toString(), 1, projects2.size());

		Page<Project> page3 = ProjectResource.getAccountProjectsPage(
			accountId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2, project3),
			(List<Project>)page3.getItems());
	}

	protected Project testGetAccountProjectsPage_addProject(
			Long accountId, Project project)
		throws Exception {

		return ProjectResource.postAccountProject(accountId, project);
	}

	protected Long testGetAccountProjectsPage_getAccountId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAccountProjectsPage_getIrrelevantAccountId()
		throws Exception {

		return null;
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

		return ProjectResource.postAccountProject(
			testGetAccountProjectsPage_getAccountId(), project);
	}

	@Test
	public void testDeleteProject() throws Exception {
		Project project = testDeleteProject_addProject();

		assertHttpResponseStatusCode(
			204, ProjectResource.deleteProjectHttpResponse(project.getId()));

		assertHttpResponseStatusCode(
			404, ProjectResource.getProjectHttpResponse(project.getId()));

		assertHttpResponseStatusCode(
			404, ProjectResource.getProjectHttpResponse(0L));
	}

	protected Project testDeleteProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProject() throws Exception {
		Project postProject = testGetProject_addProject();

		Project getProject = ProjectResource.getProject(postProject.getId());

		assertEquals(postProject, getProject);
		assertValid(getProject);
	}

	protected Project testGetProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutProject() throws Exception {
		Project postProject = testPutProject_addProject();

		Project randomProject = randomProject();

		Project putProject = ProjectResource.putProject(
			postProject.getId(), randomProject);

		assertEquals(randomProject, putProject);
		assertValid(putProject);

		Project getProject = ProjectResource.getProject(putProject.getId());

		assertEquals(randomProject, getProject);
		assertValid(getProject);
	}

	protected Project testPutProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteProjectContact() throws Exception {
		Project project = testDeleteProjectContact_addProject();

		assertHttpResponseStatusCode(
			204,
			ProjectResource.deleteProjectContactHttpResponse(
				project.getId(), null));
	}

	protected Project testDeleteProjectContact_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutProjectContact() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteProjectContactRole() throws Exception {
		Project project = testDeleteProjectContactRole_addProject();

		assertHttpResponseStatusCode(
			204,
			ProjectResource.deleteProjectContactRoleHttpResponse(
				project.getId(), null, null));
	}

	protected Project testDeleteProjectContactRole_addProject()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutProjectContactRole() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteProjectTeamRole() throws Exception {
		Project project = testDeleteProjectTeamRole_addProject();

		assertHttpResponseStatusCode(
			204,
			ProjectResource.deleteProjectTeamRoleHttpResponse(
				project.getId(), null, null));
	}

	protected Project testDeleteProjectTeamRole_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutProjectTeamRole() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
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

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (project.getExternalLinks() == null) {
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

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getExternalLinks(),
						project2.getExternalLinks())) {

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

		if (entityFieldName.equals("externalLinks")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected Project randomProject() throws Exception {
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

	protected Project randomIrrelevantProject() throws Exception {
		Project randomIrrelevantProject = randomProject();

		return randomIrrelevantProject;
	}

	protected Project randomPatchProject() throws Exception {
		return randomProject();
	}

	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

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
	private com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource
		_projectResource;

}