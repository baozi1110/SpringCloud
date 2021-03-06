package com.example.gatewaydemo.utils;


import com.example.gatewaydemo.Constant.UaaConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;

/**
 * @author Baozi
 */
public class TokenUtil {
	public  static String extractToken(ServerHttpRequest request) {
		List<String> strings = request.getHeaders().get(UaaConstant.Authorization);
		String authToken = "";
		if (strings != null) {
			authToken = strings.get(0).substring("Bearer".length()).trim();
		}

		if (StringUtils.isBlank(authToken)) {
			strings = request.getQueryParams().get(UaaConstant.TOKEN_PARAM);
			if (strings != null) {
				authToken = strings.get(0);
			}
		}

		return authToken;
	}
}
