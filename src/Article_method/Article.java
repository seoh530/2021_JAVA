package Article_method;

public class Article {

	public int id;
	public int hit;
	public String title;
	public String body;
	public String date;

	public Article(int id, String title, String body, String date) {
		this(id, title, body, date, 0);
	}

	public Article(int id, String title, String body, String date, int hit) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.hit = hit;
	}

	public void increase_hit() {
		hit++;
	}
}