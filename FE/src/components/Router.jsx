import React from "react";
import { BrowserRouter as Router, Route, Redirect, Switch } from "react-router-dom";
import Login from "Routes/Login.jsx";
import TeamChoice from "Routes/TeamChoice.jsx";
import Game from "Routes/Game.jsx";
import PlayerRecord from "Routes/PlayerRecord.jsx";
import { PATH } from "Utils/const";

export default () => (
	<Router>
		<Switch>
			<Route path={PATH.LOGIN} exact component={Login} />
			<Route path={PATH.TEAM_CHOICE} component={TeamChoice} />
			<Route path={PATH.GAME} component={Game} />
			<Route path={PATH.PLAYER_RECORD} component={PlayerRecord} />
			<Redirect from="*" to="/" />
		</Switch>
	</Router>
);
