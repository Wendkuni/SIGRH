package com.nyn.eHabita.entities.common.constant;

/**
 * 
 * @author AK
 *
 * @param <T>
 */
public class ApiResponse<T> {
	private int status;
	private String message;
	private T result;
	
	public ApiResponse(Builder<T> builder) {
		this.status = builder.status;
		this.message = builder.message;
		this.result = builder.result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
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


