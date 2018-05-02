package com.dxc.msf.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class AbstractDTO implements Serializable {

	public static final long serialVersionUID = 1L;
	
	
	abstract public String toJSon() throws JsonProcessingException;
}
