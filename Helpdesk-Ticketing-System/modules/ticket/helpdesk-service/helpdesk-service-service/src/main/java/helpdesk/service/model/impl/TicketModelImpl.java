/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package helpdesk.service.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import helpdesk.service.model.Ticket;
import helpdesk.service.model.TicketModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Ticket service. Represents a row in the &quot;helpdesk_Ticket&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TicketModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketImpl
 * @generated
 */
public class TicketModelImpl
	extends BaseModelImpl<Ticket> implements TicketModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket model instance should use the <code>Ticket</code> interface instead.
	 */
	public static final String TABLE_NAME = "helpdesk_Ticket";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"requester", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"subject", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"department", Types.VARCHAR}, {"category", Types.VARCHAR},
		{"subcategory", Types.VARCHAR}, {"priority", Types.VARCHAR},
		{"imageattached", Types.VARCHAR}, {"status", Types.VARCHAR},
		{"createdate", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("requester", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("department", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subcategory", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("imageattached", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table helpdesk_Ticket (ticketId LONG not null primary key,userId LONG,requester VARCHAR(75) null,email VARCHAR(75) null,subject VARCHAR(75) null,description VARCHAR(75) null,department VARCHAR(75) null,category VARCHAR(75) null,subcategory VARCHAR(75) null,priority VARCHAR(75) null,imageattached TEXT null,status VARCHAR(75) null,createdate VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table helpdesk_Ticket";

	public static final String ORDER_BY_JPQL = " ORDER BY ticket.ticketId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY helpdesk_Ticket.ticketId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEPARTMENT_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TICKETID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public TicketModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Ticket.class;
	}

	@Override
	public String getModelClassName() {
		return Ticket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Ticket, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Ticket, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ticket, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Ticket)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Ticket, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Ticket, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Ticket)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Ticket, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Ticket, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Ticket, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Ticket, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Ticket, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Ticket, Object>>();
		Map<String, BiConsumer<Ticket, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Ticket, ?>>();

		attributeGetterFunctions.put("ticketId", Ticket::getTicketId);
		attributeSetterBiConsumers.put(
			"ticketId", (BiConsumer<Ticket, Long>)Ticket::setTicketId);
		attributeGetterFunctions.put("userId", Ticket::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Ticket, Long>)Ticket::setUserId);
		attributeGetterFunctions.put("requester", Ticket::getRequester);
		attributeSetterBiConsumers.put(
			"requester", (BiConsumer<Ticket, String>)Ticket::setRequester);
		attributeGetterFunctions.put("email", Ticket::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Ticket, String>)Ticket::setEmail);
		attributeGetterFunctions.put("subject", Ticket::getSubject);
		attributeSetterBiConsumers.put(
			"subject", (BiConsumer<Ticket, String>)Ticket::setSubject);
		attributeGetterFunctions.put("description", Ticket::getDescription);
		attributeSetterBiConsumers.put(
			"description", (BiConsumer<Ticket, String>)Ticket::setDescription);
		attributeGetterFunctions.put("department", Ticket::getDepartment);
		attributeSetterBiConsumers.put(
			"department", (BiConsumer<Ticket, String>)Ticket::setDepartment);
		attributeGetterFunctions.put("category", Ticket::getCategory);
		attributeSetterBiConsumers.put(
			"category", (BiConsumer<Ticket, String>)Ticket::setCategory);
		attributeGetterFunctions.put("subcategory", Ticket::getSubcategory);
		attributeSetterBiConsumers.put(
			"subcategory", (BiConsumer<Ticket, String>)Ticket::setSubcategory);
		attributeGetterFunctions.put("priority", Ticket::getPriority);
		attributeSetterBiConsumers.put(
			"priority", (BiConsumer<Ticket, String>)Ticket::setPriority);
		attributeGetterFunctions.put("imageattached", Ticket::getImageattached);
		attributeSetterBiConsumers.put(
			"imageattached",
			(BiConsumer<Ticket, String>)Ticket::setImageattached);
		attributeGetterFunctions.put("status", Ticket::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Ticket, String>)Ticket::setStatus);
		attributeGetterFunctions.put("createdate", Ticket::getCreatedate);
		attributeSetterBiConsumers.put(
			"createdate", (BiConsumer<Ticket, String>)Ticket::setCreatedate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getTicketId() {
		return _ticketId;
	}

	@Override
	public void setTicketId(long ticketId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ticketId = ticketId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@Override
	public String getRequester() {
		if (_requester == null) {
			return "";
		}
		else {
			return _requester;
		}
	}

	@Override
	public void setRequester(String requester) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_requester = requester;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@Override
	public String getSubject() {
		if (_subject == null) {
			return "";
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subject = subject;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public String getDepartment() {
		if (_department == null) {
			return "";
		}
		else {
			return _department;
		}
	}

	@Override
	public void setDepartment(String department) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_department = department;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalDepartment() {
		return getColumnOriginalValue("department");
	}

	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_category = category;
	}

	@Override
	public String getSubcategory() {
		if (_subcategory == null) {
			return "";
		}
		else {
			return _subcategory;
		}
	}

	@Override
	public void setSubcategory(String subcategory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subcategory = subcategory;
	}

	@Override
	public String getPriority() {
		if (_priority == null) {
			return "";
		}
		else {
			return _priority;
		}
	}

	@Override
	public void setPriority(String priority) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_priority = priority;
	}

	@Override
	public String getImageattached() {
		if (_imageattached == null) {
			return "";
		}
		else {
			return _imageattached;
		}
	}

	@Override
	public void setImageattached(String imageattached) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_imageattached = imageattached;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public String getCreatedate() {
		if (_createdate == null) {
			return "";
		}
		else {
			return _createdate;
		}
	}

	@Override
	public void setCreatedate(String createdate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdate = createdate;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Ticket.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Ticket toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Ticket>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketImpl ticketImpl = new TicketImpl();

		ticketImpl.setTicketId(getTicketId());
		ticketImpl.setUserId(getUserId());
		ticketImpl.setRequester(getRequester());
		ticketImpl.setEmail(getEmail());
		ticketImpl.setSubject(getSubject());
		ticketImpl.setDescription(getDescription());
		ticketImpl.setDepartment(getDepartment());
		ticketImpl.setCategory(getCategory());
		ticketImpl.setSubcategory(getSubcategory());
		ticketImpl.setPriority(getPriority());
		ticketImpl.setImageattached(getImageattached());
		ticketImpl.setStatus(getStatus());
		ticketImpl.setCreatedate(getCreatedate());

		ticketImpl.resetOriginalValues();

		return ticketImpl;
	}

	@Override
	public Ticket cloneWithOriginalValues() {
		TicketImpl ticketImpl = new TicketImpl();

		ticketImpl.setTicketId(this.<Long>getColumnOriginalValue("ticketId"));
		ticketImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		ticketImpl.setRequester(
			this.<String>getColumnOriginalValue("requester"));
		ticketImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		ticketImpl.setSubject(this.<String>getColumnOriginalValue("subject"));
		ticketImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		ticketImpl.setDepartment(
			this.<String>getColumnOriginalValue("department"));
		ticketImpl.setCategory(this.<String>getColumnOriginalValue("category"));
		ticketImpl.setSubcategory(
			this.<String>getColumnOriginalValue("subcategory"));
		ticketImpl.setPriority(this.<String>getColumnOriginalValue("priority"));
		ticketImpl.setImageattached(
			this.<String>getColumnOriginalValue("imageattached"));
		ticketImpl.setStatus(this.<String>getColumnOriginalValue("status"));
		ticketImpl.setCreatedate(
			this.<String>getColumnOriginalValue("createdate"));

		return ticketImpl;
	}

	@Override
	public int compareTo(Ticket ticket) {
		long primaryKey = ticket.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Ticket)) {
			return false;
		}

		Ticket ticket = (Ticket)object;

		long primaryKey = ticket.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Ticket> toCacheModel() {
		TicketCacheModel ticketCacheModel = new TicketCacheModel();

		ticketCacheModel.ticketId = getTicketId();

		ticketCacheModel.userId = getUserId();

		ticketCacheModel.requester = getRequester();

		String requester = ticketCacheModel.requester;

		if ((requester != null) && (requester.length() == 0)) {
			ticketCacheModel.requester = null;
		}

		ticketCacheModel.email = getEmail();

		String email = ticketCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			ticketCacheModel.email = null;
		}

		ticketCacheModel.subject = getSubject();

		String subject = ticketCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			ticketCacheModel.subject = null;
		}

		ticketCacheModel.description = getDescription();

		String description = ticketCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ticketCacheModel.description = null;
		}

		ticketCacheModel.department = getDepartment();

		String department = ticketCacheModel.department;

		if ((department != null) && (department.length() == 0)) {
			ticketCacheModel.department = null;
		}

		ticketCacheModel.category = getCategory();

		String category = ticketCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			ticketCacheModel.category = null;
		}

		ticketCacheModel.subcategory = getSubcategory();

		String subcategory = ticketCacheModel.subcategory;

		if ((subcategory != null) && (subcategory.length() == 0)) {
			ticketCacheModel.subcategory = null;
		}

		ticketCacheModel.priority = getPriority();

		String priority = ticketCacheModel.priority;

		if ((priority != null) && (priority.length() == 0)) {
			ticketCacheModel.priority = null;
		}

		ticketCacheModel.imageattached = getImageattached();

		String imageattached = ticketCacheModel.imageattached;

		if ((imageattached != null) && (imageattached.length() == 0)) {
			ticketCacheModel.imageattached = null;
		}

		ticketCacheModel.status = getStatus();

		String status = ticketCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			ticketCacheModel.status = null;
		}

		ticketCacheModel.createdate = getCreatedate();

		String createdate = ticketCacheModel.createdate;

		if ((createdate != null) && (createdate.length() == 0)) {
			ticketCacheModel.createdate = null;
		}

		return ticketCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Ticket, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Ticket, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ticket, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Ticket)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Ticket>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Ticket.class, ModelWrapper.class);

	}

	private long _ticketId;
	private long _userId;
	private String _requester;
	private String _email;
	private String _subject;
	private String _description;
	private String _department;
	private String _category;
	private String _subcategory;
	private String _priority;
	private String _imageattached;
	private String _status;
	private String _createdate;

	public <T> T getColumnValue(String columnName) {
		Function<Ticket, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Ticket)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("ticketId", _ticketId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("requester", _requester);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("subject", _subject);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("department", _department);
		_columnOriginalValues.put("category", _category);
		_columnOriginalValues.put("subcategory", _subcategory);
		_columnOriginalValues.put("priority", _priority);
		_columnOriginalValues.put("imageattached", _imageattached);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("createdate", _createdate);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("ticketId", 1L);

		columnBitmasks.put("userId", 2L);

		columnBitmasks.put("requester", 4L);

		columnBitmasks.put("email", 8L);

		columnBitmasks.put("subject", 16L);

		columnBitmasks.put("description", 32L);

		columnBitmasks.put("department", 64L);

		columnBitmasks.put("category", 128L);

		columnBitmasks.put("subcategory", 256L);

		columnBitmasks.put("priority", 512L);

		columnBitmasks.put("imageattached", 1024L);

		columnBitmasks.put("status", 2048L);

		columnBitmasks.put("createdate", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Ticket _escapedModel;

}