package com.qlik.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Palindrome {

	private String paragraph;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paragraph == null) ? 0 : paragraph.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palindrome other = (Palindrome) obj;
		if (paragraph == null) {
			if (other.paragraph != null)
				return false;
		} else if (!paragraph.equals(other.paragraph))
			return false;
		return true;
	}

}
