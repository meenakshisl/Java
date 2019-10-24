package aoc.dto;


public class AcademicDTO {

	private String loginname;
	private int yearofpass;
	private int yearofjoin;
	private String profession;
	private String rollno;
	private String email;
	private long phoneno;
	private String gender;
	private String password;

	public AcademicDTO()
	{
		
	}
	public AcademicDTO(String rollno , String loginname , String gender , String email  , long phoneno, int yearofjoin, int yearofpass, String profession, String pass)
	{
		this.rollno = rollno;
		this.loginname = loginname;
		this.gender = gender;
		this.email = email;
		this.phoneno = phoneno;
		this.yearofjoin = yearofjoin;
		this.profession = profession;
		this.yearofpass = yearofpass;
		this.password = pass;
	}
	public String getPass()
	{
		return password;
	}
	
	public void setPass(String pass)
	{
		this.password = pass;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	/**
	 * @return the loginname
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * @param loginname the loginname to set
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * @return the yearofpass
	 */
	public int getYearofpass() {
		return yearofpass;
	}
	/**
	 * @param yearofpass the yearofpass to set
	 */
	public void setYearofpass(int yearofpass) {
		this.yearofpass = yearofpass;
	}
	/**
	 * @return the yearofjoining
	 */
	public int getYearofjoin() {
		return yearofjoin;
	}
	/**
	 * @param yearofjoining the yearofjoining to set
	 */
	public void setYearofjoin(int yearofjoining) {
		this.yearofjoin = yearofjoining;
	}
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * @return the rollno
	 */
	public String getRollno() {
		return rollno;
	}
	/**
	 * @param rollno the rollno to set
	 */
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPhone(long phoneno)
	{
		this.phoneno = phoneno;
	}
	public long getPhone()
	{
		return phoneno;
	}
	
	@Override
	public String toString()
	{
		return String.format("Alumni [rollno=%s, Name=%s, gender=%s, email=%s, phoneno=%d,profession = %s], args)",rollno,loginname,gender,email,phoneno,profession);
		
	}
}