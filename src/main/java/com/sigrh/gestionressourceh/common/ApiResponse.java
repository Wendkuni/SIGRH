package com.sigrh.gestionressourceh.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author AK
 *
 * @param <T>
 */

@Getter @Setter 
public class ApiResponse<T> {
	private int status;
	private String message;
	private T result;
	
	public ApiResponse(Builder<T> builder) {
		this.status = builder.status;
		this.message = builder.message;
		this.result = builder.result;
	}

	

	public static class Builder<T> {
		private int status;
		private String message;
		private T result;

		public Builder<T> status(int status) {
			this.status = status;
			return this;
		}

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}

		public Builder<T> result(T result) {
			this.result = result;
			return this;
		}
		
		public ApiResponse<T> build() {
			return new ApiResponse<T>(this);
		}

	}

	

}


