// Description: Java 25 CFSec Public Authorization Implementation

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsecpub;

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;

/*
 *	A CFSecPubAuthorization is a public authorization ticket
 *	for the system providing services.  Most modern authorizations
 *	are based on OAuth2 tickets, but I haven't gotten there yet.
 */
public class CFSecPubAuthorization implements ICFSecPubAuthorization, Serializable
{
	protected CFLibUuid6 authUuid6;
	protected String authUuid6Str;

	protected CFLibDbKeyHash256 secSessionId;
	protected CFLibDbKeyHash256 secUserId;

	public CFSecPubAuthorization() {
		authUuid6 = CFLibUuid6.generateUuid6();
		authUuid6Str = authUuid6.toString();
		secSessionId = CFLibDbKeyHash256.nullGet();
		secUserId = CFLibDbKeyHash256.nullGet();
	}

	public CFSecPubAuthorization(ICFSecPubAuthorization src) {
		authUuid6 = new CFLibUuid6(src.getAuthUuid6().getBytes());
		authUuid6Str = authUuid6.toString();
		secSessionId = new CFLibDbKeyHash256(src.getSecSessionId());
		secUserId = new CFLibDbKeyHash256(src.getSecUserId());
	}

	public CFLibUuid6 getAuthUuid6() {
		return( authUuid6 );
	}

	public String getAuthUuid6Str() {
		return( authUuid6Str );
	}

	public CFLibDbKeyHash256 getSecSessionId() {
		return( secSessionId );
	}

	public CFLibDbKeyHash256 getSecUserId() {
		return( secUserId );
	}
}
