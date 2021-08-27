package project;

import java.text.SimpleDateFormat;
import java.util.*;

public class bulletin_board {

	public static void main(String[] args) {

		System.out.println("===Program Start===");

		Scanner scan = new Scanner(System.in);

		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("\nEnter your order: ");

			String command = scan.nextLine().trim();

			if (command.length() == 0) {
				continue;
			}
			if (command.equals("system exit")) {
				break;
			}
			if (command.equals("system detail")) {
				if (command.length() == 0) {
					System.out.println("There is no article");
				}
			}
			if (command.equals("article write")) {

				int id = lastArticleId + 1;
				lastArticleId = id;

				System.out.print("Title: ");
				String title = scan.nextLine();
				System.out.print("Body: ");
				String body = scan.nextLine();
				String date = util.getNowDate();
	
				Article article = new Article(id, title, body, date);

				articles.add(article);
				// Array list인 articles에 Article class안에 입력된 Article method(integer, title,
				// body)값을
				// 저장(추가)한다.

				System.out.printf("Number %d article is completed\n", id);
			}

			else if (command.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("There's no article\n");
					continue;
				}

				System.out.printf("===Article List===\n");

				for (int i = articles.size() - 1; i >= 0; i--) {
					// array list 안에는 0부터 n까지 이므로 integer i의 사이즈는 n+1. 그러므로 최대 사이즈는 n-1로 설정해야함.
					Article article = articles.get(i);

					System.out.printf("Id:%d,  Title:%s  Hit: %d\n", article.id, article.title, article.hit);
				}

			} else if (command.startsWith("article detail ")) {
				// starts with: !로 시작해라.
				// split : split(" ") 스페이스바를 기준으로 문장을 쪼갠다. Hi I'm se. --> "Hi", "I'm", "se"
				

				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]); // "1" -> 1

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) { // 0 1 2 3 4
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("There's no [%d article] in the board.\n", id);
					continue;
					
					//foundArticle.increase_hit();

				} else {
					foundArticle.increase_hit();
					System.out.printf("|Number: %d\n", foundArticle.id);
					System.out.printf("|Date  : %s\n", foundArticle.date);
					System.out.printf("|Title : %s\n", foundArticle.title);
					System.out.printf("|Body  : %s\n", foundArticle.body);
					System.out.printf("|Hit   : %d\n", foundArticle.hit);
				}
				
			} else if (command.startsWith("article delete ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]); // String type을 integer type으로 바꿈

				// Article foundArticle = null; --> article detail
				int foundIndex;

				for (foundIndex = 0; foundIndex < articles.size(); foundIndex++) {
					Article article = articles.get(foundIndex);

					// There's a situation that the index number of Array list and the id
					// is not same.
					// To solve this situation, I need to find the index number first and delete
					// articles
					// based on the index number..

					if (article.id == id) {
						// foundArticle = article;
						// foundIndex = i;
						articles.remove(foundIndex);
						System.out.printf("Number %d article is deleted\n", id);
						break;
					}
				}
				if (foundIndex >= articles.size()) {

					System.out.printf("There's no [%d article] in the board.\n", id);
					continue;

				}
			} else if (command.startsWith("article modify ")) {

				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) { // 0 1 2 3 4
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("There's no [%d article] in the board.\n", id);
					continue;
				}
				
				System.out.print("Title: ");
				String title = scan.nextLine();
				System.out.print("Body: ");
				String body = scan.nextLine();
				String date = util.getNowDate();
				
				foundArticle.title = title;
				foundArticle.body = body;
				foundArticle.date = date;
				
				System.out.printf("Number %d article modification is completed.\n",foundArticle.id);
			}

			else {
				System.out.printf("%s is invalid order. Try again\n", command);
			}

		} // while fin.

		scan.close();
		System.out.println("===Program End===");
	}
}// main class fin.

class Article {

	int id;
	int hit;
	String title;
	String body;
	String date;

	public Article(int id, String title, String body, String date) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.hit = 0;
	}
	
	public void increase_hit() {
		hit++;
	}

}
