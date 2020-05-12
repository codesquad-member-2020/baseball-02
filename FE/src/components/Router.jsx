import React from "react";
import { BrowserRouter as Router, Route, Redirect, Switch } from "react-router-dom";
import Home from "Routes/Home.jsx";
import TeamChoice from "Routes/TeamChoice.jsx";
import Match from "Routes/Match.jsx";
import PlayerRecord from "Routes/PlayerRecord.jsx";
import { PATH } from "Utils/const";

export default () => (
	<Router>
		<Switch>
			<Route path={PATH.HOME} exact component={Home} />
			<Route path={PATH.TEAM_CHOICE} component={TeamChoice} />
			<Route path={PATH.MATCH} component={Match} />
			<Route path={PATH.PLAYER_RECORD} component={PlayerRecord} />
			<Redirect from="*" to="/" />
		</Switch>
	</Router>
);
