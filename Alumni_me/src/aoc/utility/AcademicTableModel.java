package aoc.utility;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import aoc.dto.AcademicDTO;


public class AcademicTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ROLL_COL = 0;
	private static final int NAME_COL = 1;
	private static final int YOJ_COL = 2;
	private static final int YOP_COL = 3;
	private static final int PROF_COL = 4;
	private static final int MAIL_COL = 5;

	private String[] columnNames = { "Roll No", "Name", "Year of Join","Year of Pass","Profession","Mail" };
	private List<AcademicDTO> alum_l;

	public AcademicTableModel(List<AcademicDTO> thealumni) {
		alum_l= thealumni;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return alum_l.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		AcademicDTO tempA = alum_l.get(row);

		switch (col) {
		case ROLL_COL:
			return tempA.getRollno();
		case NAME_COL:
			return tempA.getLoginname();
		case YOJ_COL:
			return tempA.getYearofjoin();
		case PROF_COL:
			return tempA.getProfession();
		case YOP_COL :
			return tempA.getYearofpass();
		case MAIL_COL :
			return tempA.getEmail();
		default:
			return tempA.getLoginname();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(1, c).getClass();
	}
}