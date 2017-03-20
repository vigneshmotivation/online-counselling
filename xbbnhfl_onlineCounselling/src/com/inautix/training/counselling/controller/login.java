package com.inautix.training.counselling.controller;

import com.inautix.training.counselling.exception.loginFailure;

public interface login {

	abstract void getCredentials() throws loginFailure;
}

