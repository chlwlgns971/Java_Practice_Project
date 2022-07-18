package MVCBoard;

public class BoardVO {
	private String title;
	private String writer;
	private String board_cnt;
	private String content;
	private String date;
	private int board_no;
	
	public BoardVO(String title, String writer, String board_cnt, int board_no) {
		super();
		this.title = title;
		this.writer = writer;
		this.board_cnt = board_cnt;
		this.board_no = board_no;
	}

	public BoardVO(String title, String writer, String board_cnt, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.board_cnt = board_cnt;
		this.content = content;
	}
	
	public BoardVO(String title, String writer, String board_cnt, String content, String date, int board_no) {
		super();
		this.title = title;
		this.writer = writer;
		this.board_cnt = board_cnt;
		this.content = content;
		this.date = date;
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(String board_cnt) {
		this.board_cnt = board_cnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BoardVO [title=" + title + ", writer=" + writer + ", board_cnt=" + board_cnt + ", content=" + content
				+ "]";
	}
}
