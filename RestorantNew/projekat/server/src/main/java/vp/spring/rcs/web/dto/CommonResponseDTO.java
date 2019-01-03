package vp.spring.rcs.web.dto;

public class CommonResponseDTO {
	public CommonResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonResponseDTO(String text) {
		super();
		this.text = text;
	}

	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
