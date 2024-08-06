/*package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_forms",schema="dbo")
public class Form {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FormId", columnDefinition = "varchar(400) default newid()")
	private String formId;
	
	@Column(name = "Title", columnDefinition = "varchar(200) default NULL")
	private String title;
	
	@Column(name = "DisplayColumn", columnDefinition = "varchar(500) default NULL")
	private String displayColumn;
	
	@Column(name = "SelectQuery", columnDefinition = "varchar(500) default NULL")
	private String selectQuery;
	
	@Column(name = "AddQuery", columnDefinition = "varchar(500) default NULL")
	private String addQuery;
	
	@Column(name = "EditQuery", columnDefinition = "varchar(500) default NULL")
	private String editQuery;
	
	@Column(name = "DeleteQuery", columnDefinition = "varchar(500) default NULL")
	private String deleteQuery;
	
	@Column(name = "EnableActions", columnDefinition = "bit default NULL")
	private Boolean enableActions;
	
	@Column(name = "CreateEditUI", columnDefinition = "varchar(max) default NULL")
	private String createEditUI;
	
	@Column(name = "EnableUpload", columnDefinition = "bit default NULL")
	private Boolean enableUpload;
	
	@Column(name = "EnableEdit", columnDefinition = "bit default 0")
	private Boolean enableEdit;
	
	@Column(name = "EnableDelete", columnDefinition = "bit default 0")
	private Boolean enableDelete;
	
	@Column(name = "EnableView", columnDefinition = "bit default 0")
	private Boolean enableView;

	@Column(name = "EnableAudit", columnDefinition = "bit default 0")
	private Boolean enableAudit;
	
	@Column(name = "UploadColumns", columnDefinition = "varchar(500) default NULL")
	private String uploadColumns;
	
	@Column(name = "UploadSample", columnDefinition = "varchar(400) default NULL")
	private String uploadSample;
	
	@Column(name = "UploadQuery", columnDefinition = "varchar(700) default NULL")
	private String uploadQuery;
	
	@Column(name = "EnableTopActions", columnDefinition = "bit default NULL")
	private Boolean enableTopActions;
	
	@Column(name = "BespokeAction", columnDefinition = "varchar(max) default NULL")
	private String bespokeAction;
	
	@Column(name = "ViewQuery", columnDefinition = "varchar(max) default NULL")
	private String viewQuery;
	
	@Column(name = "EnableAdd", columnDefinition = "bit default NULL")
	private Boolean enableAdd;
	

	@Column(name = "ViewMenu", columnDefinition = "varchar(max) default NULL")
	private String viewMenu;
	
	
	@Column(name = "EnableApproval", columnDefinition = "bit default NULL")
	private Boolean enableApproval;
	
	@Column(name = "EnableEmail", columnDefinition = "bit default NULL")
	private Boolean enableEmail;
	
	@Column(name = "ApprovalCommand", columnDefinition = "varchar(100) default NULL")
	private String approvalCommand;
	
	@Column(name = "EmailCommand", columnDefinition = "varchar(100) default NULL")
	private String emailCommand;
	
	@Column(name = "EnableMisCode", columnDefinition = "bit default NULL")
	private Boolean enableMisCode;

	public Form() {
		super();
	}

	public Form( String formId, String title, String displayColumn, String selectQuery, String addQuery,
			String editQuery, String deleteQuery, Boolean enableActions, String createEditUI, Boolean enableUpload,
			Boolean enableEdit, Boolean enableDelete, Boolean enableView, Boolean enableAudit, String uploadColumns,
			String uploadSample, String uploadQuery, Boolean enableTopActions, String bespokeAction, String viewQuery,
			Boolean enableAdd, String viewMenu, Boolean enableApproval, Boolean enableEmail, String approvalCommand,
			String emailCommand, Boolean enableMisCode) {
		super();
		this.formId = formId;
		this.title = title;
		this.displayColumn = displayColumn;
		this.selectQuery = selectQuery;
		this.addQuery = addQuery;
		this.editQuery = editQuery;
		this.deleteQuery = deleteQuery;
		this.enableActions = enableActions;
		this.createEditUI = createEditUI;
		this.enableUpload = enableUpload;
		this.enableEdit = enableEdit;
		this.enableDelete = enableDelete;
		this.enableView = enableView;
		this.enableAudit = enableAudit;
		this.uploadColumns = uploadColumns;
		this.uploadSample = uploadSample;
		this.uploadQuery = uploadQuery;
		this.enableTopActions = enableTopActions;
		this.bespokeAction = bespokeAction;
		this.viewQuery = viewQuery;
		this.enableAdd = enableAdd;
		this.viewMenu = viewMenu;
		this.enableApproval = enableApproval;
		this.enableEmail = enableEmail;
		this.approvalCommand = approvalCommand;
		this.emailCommand = emailCommand;
		this.enableMisCode = enableMisCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDisplayColumn() {
		return displayColumn;
	}

	public void setDisplayColumn(String displayColumn) {
		this.displayColumn = displayColumn;
	}

	public String getSelectQuery() {
		return selectQuery;
	}

	public void setSelectQuery(String selectQuery) {
		this.selectQuery = selectQuery;
	}

	public String getAddQuery() {
		return addQuery;
	}

	public void setAddQuery(String addQuery) {
		this.addQuery = addQuery;
	}

	public String getEditQuery() {
		return editQuery;
	}

	public void setEditQuery(String editQuery) {
		this.editQuery = editQuery;
	}

	public String getDeleteQuery() {
		return deleteQuery;
	}

	public void setDeleteQuery(String deleteQuery) {
		this.deleteQuery = deleteQuery;
	}

	public Boolean getEnableActions() {
		return enableActions;
	}

	public void setEnableActions(Boolean enableActions) {
		this.enableActions = enableActions;
	}

	public String getCreateEditUI() {
		return createEditUI;
	}

	public void setCreateEditUI(String createEditUI) {
		this.createEditUI = createEditUI;
	}

	public Boolean getEnableUpload() {
		return enableUpload;
	}

	public void setEnableUpload(Boolean enableUpload) {
		this.enableUpload = enableUpload;
	}

	public Boolean getEnableEdit() {
		return enableEdit;
	}

	public void setEnableEdit(Boolean enableEdit) {
		this.enableEdit = enableEdit;
	}

	public Boolean getEnableDelete() {
		return enableDelete;
	}

	public void setEnableDelete(Boolean enableDelete) {
		this.enableDelete = enableDelete;
	}

	public Boolean getEnableView() {
		return enableView;
	}

	public void setEnableView(Boolean enableView) {
		this.enableView = enableView;
	}

	public Boolean getEnableAudit() {
		return enableAudit;
	}

	public void setEnableAudit(Boolean enableAudit) {
		this.enableAudit = enableAudit;
	}

	public String getUploadColumns() {
		return uploadColumns;
	}

	public void setUploadColumns(String uploadColumns) {
		this.uploadColumns = uploadColumns;
	}

	public String getUploadSample() {
		return uploadSample;
	}

	public void setUploadSample(String uploadSample) {
		this.uploadSample = uploadSample;
	}

	public String getUploadQuery() {
		return uploadQuery;
	}

	public void setUploadQuery(String uploadQuery) {
		this.uploadQuery = uploadQuery;
	}

	public Boolean getEnableTopActions() {
		return enableTopActions;
	}

	public void setEnableTopActions(Boolean enableTopActions) {
		this.enableTopActions = enableTopActions;
	}

	public String getBespokeAction() {
		return bespokeAction;
	}

	public void setBespokeAction(String bespokeAction) {
		this.bespokeAction = bespokeAction;
	}

	public String getViewQuery() {
		return viewQuery;
	}

	public void setViewQuery(String viewQuery) {
		this.viewQuery = viewQuery;
	}

	public Boolean getEnableAdd() {
		return enableAdd;
	}

	public void setEnableAdd(Boolean enableAdd) {
		this.enableAdd = enableAdd;
	}

	public String getViewMenu() {
		return viewMenu;
	}

	public void setViewMenu(String viewMenu) {
		this.viewMenu = viewMenu;
	}

	public Boolean getEnableApproval() {
		return enableApproval;
	}

	public void setEnableApproval(Boolean enableApproval) {
		this.enableApproval = enableApproval;
	}

	public Boolean getEnableEmail() {
		return enableEmail;
	}

	public void setEnableEmail(Boolean enableEmail) {
		this.enableEmail = enableEmail;
	}

	public String getApprovalCommand() {
		return approvalCommand;
	}

	public void setApprovalCommand(String approvalCommand) {
		this.approvalCommand = approvalCommand;
	}

	public String getEmailCommand() {
		return emailCommand;
	}

	public void setEmailCommand(String emailCommand) {
		this.emailCommand = emailCommand;
	}

	public Boolean getEnableMisCode() {
		return enableMisCode;
	}

	public void setEnableMisCode(Boolean enableMisCode) {
		this.enableMisCode = enableMisCode;
	}
	
	
	
	
	

}

*/
