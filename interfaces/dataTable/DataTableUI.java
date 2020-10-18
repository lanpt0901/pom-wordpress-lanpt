package dataTable;

public class DataTableUI {

	public static final String DYNAMIC_TEXTBOX_BY_COLUNM_NAME = "//div[text()='%s']/parent::div/following-sibling::input";
	////td[@data-key='country' and text()='AFRICA']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'edit')]
	public static final String DYNAMIC_EDIT_OR_REMOVE_BY_COLUNM_NAME_AND_TEXT = "//td[@data-key='%s' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	public static final String DYNAMIC_TD_DATA_ROW = "//td[text()='%s']";
	public static final String DYNAMIC_PAGE = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String DYNAMIC_PAGING_ACTIVE = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String NUMBER_OF_ROW_BEFORE_CELL_WITH_COLUMN_NAME = "//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_CELL_BY_ROW_INDEX_COLUMN_INDEX = "//tr[%s]/td[%s]/input";
	

}
