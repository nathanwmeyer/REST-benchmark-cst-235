package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@ManagedBean
	@SessionScoped
public class Bible {
	
		public Bible(String search, String passage) {
			super();
			this.passage = passage;
			this.search = search;
		}
		
		public Bible()
		{
			this.passage = "Blessed be the God and Father of our Lord Jesus Christ, the Father of mercies and God of all comfort, who comforts us in all our affliction, so that we may be able to comfort those who are in any affliction, with the comfort with which we ourselves are comforted by God.";
			this.search = "father";
		}
		private String passage;
		
		@NotNull() @Size(min=2, max=15)
		private String search;

		public String getPassage() {
			return passage;
		}

		public void setPassage(String passage) {
			this.passage = passage;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}
}
