package MVCBoard;

public class BoardVO {
	private String board_title;
	private String board_writer;
	private String board_cnt;
	private String board_content;
	private String board_date;
	private int board_no;
	
	public BoardVO() {
		super();
	}

	public BoardVO(String title, String writer, String board_cnt, int board_no) {
		super();
		this.board_title = title;
		this.board_writer = writer;
		this.board_cnt = board_cnt;
		this.board_no = board_no;
	}
	
	public BoardVO(String title, String writer, String content) {
		super();
		this.board_title = title;
		this.board_writer = writer;
		this.board_content = content;
	}
	
	public BoardVO(String title, String writer, int board_no, String content) {
		super();
		this.board_title = title;
		this.board_writer = writer;
		this.board_no = board_no;
		this.board_content = content;
	}
	
	public BoardVO(String title, String writer, String board_cnt, String content, String date, int board_no) {
		super();
		this.board_title = title;
		this.board_writer = writer;
		this.board_cnt = board_cnt;
		this.board_content = content;
		this.board_date = date;
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public String getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(String board_cnt) {
		this.board_cnt = board_cnt;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	@Override
	public String toString() {
		return "BoardVO [board_title=" + board_title + ", board_writer=" + board_writer + ", board_cnt=" + board_cnt
				+ ", board_content=" + board_content + ", board_date=" + board_date + ", board_no=" + board_no + "]";
	}

	
}
