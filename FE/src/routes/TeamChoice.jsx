import React, { useState } from "react";
import { Redirect } from "react-router-dom";
import { PATH } from "Utils/const";

const TeamChoice = () => {
	const [redirect, setRedirect] = useState(false);

	const redirectToGamePage = () => {
		// start polling
		setRedirect(true);
	};

	return redirect ? (
		<Redirect to={PATH.MATCH} />
	) : (
		<>
			<h1>TeamChoice</h1>
			<button onClick={redirectToGamePage}>PLAY</button>
		</>
	);
};

export default TeamChoice;
