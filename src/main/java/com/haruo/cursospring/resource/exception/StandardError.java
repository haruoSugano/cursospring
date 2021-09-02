package com.haruo.cursospring.resource.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ControllerAdvice;

// Objeto auxiliar para informar erros padrões
@ControllerAdvice
public class StandardError  implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private Integer status; // status http do erro
		private String msg; // mensagem
		private Long timeStamp; // o instante onde aconteceu o erro
		
		public StandardError() {
		}
		
		public StandardError(Integer status, String msg, Long timeStamp) {
			super();
			this.status = status;
			this.msg = msg;
			this.timeStamp = timeStamp;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public Long getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(Long timeStamp) {
			this.timeStamp = timeStamp;
		}
}
