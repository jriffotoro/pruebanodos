package cl.gob.scj.pruebanodos.dto;

public class RespuestaJSON {

	private String description;
	private Object content;	

	public RespuestaJSON() {
	}

	public RespuestaJSON(String description, Object content) {
		this.description = description;
		this.content = content;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
