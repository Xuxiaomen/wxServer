package ai.yale.wxserver.bean;

import java.util.List;

public class NewsMessage extends BaseMessage {
	private Long ArticleCount;
	private List<Article> Articles;
	public Long getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(Long articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	@Override
	public String toString() {
		return "NewsMessage [ArticleCount=" + ArticleCount + ", Articles=" + Articles + "]";
	}
}
