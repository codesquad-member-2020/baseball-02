import React, { useState } from "react";
import { Redirect } from "react-router-dom";
import { PATH, TEAMS } from "Utils/const";
import { Wrapper, Title, TeamContainer, Team, PlayButton } from "Styles/TeamChoice";

const TeamChoice = () => {
	const [redirect, setRedirect] = useState(false);

	const redirectToGamePage = () => {
		// start polling
		setRedirect(true);
	};

	return redirect ? (
		<Redirect to={PATH.MATCH} />
	) : (
		<Wrapper>
			<Title>플레이할 팀을 선택하세요.</Title>
			<TeamContainer>
				{TEAMS.map(({ id, name }) => (
					<Team key={id}>{name}</Team>
				))}
			</TeamContainer>
			<PlayButton onClick={redirectToGamePage}>PLAY</PlayButton>
		</Wrapper>
	);
};

export default TeamChoice;
