package com.gocheeta.web.dao;

public class FeedbackFactory {
	public static FeedbackManager feedbackIns() {
		return new FeedbackManagerImpl();
	}
}
