import styled from "styled-components";

const Container = styled.div`
	position: relative;
`;

const InningInfo = styled.div`
	position: absolute;
	top: 10px;
	right: 10px;
	font-size: 22px;
`;

const PitchBtn = styled.button`
	position: absolute;
	top: 235px;
	left: 222px;
	font-size: 20px;
	color: #1d1f20;
	background: #37f734;
	width: 100px;
	height: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
	letter-spacing: 1.2;
`;

const RecordBtn = styled.button`
	position: absolute;
	right: 10px;
	bottom: 10px;
	font-size: 17px;
	width: 150px;
	height: 40px;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 3px solid #37f734;
`;

export { Container, InningInfo, PitchBtn, RecordBtn };
