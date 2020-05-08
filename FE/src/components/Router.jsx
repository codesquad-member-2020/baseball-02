import React from "react";
import { BrowserRouter as Router, Route, Redirect, Switch } from "react-router-dom";
import Login from "Routes/Login.jsx";
import TeamChoice from "Routes/TeamChoice.jsx";
import Game from "Routes/Game.jsx";
import PlayerRecord from "Routes/PlayerRecord.jsx";

export default () => (
	<Router>
		<Switch>
			<Route path="/" exact component={Login} />
			<Route path="/team-choice" component={TeamChoice} />
			<Route path="/game" component={Game} />
			<Route path="/player-record" component={PlayerRecord} />
			<Redirect from="*" to="/" />
		</Switch>
	</Router>
);
