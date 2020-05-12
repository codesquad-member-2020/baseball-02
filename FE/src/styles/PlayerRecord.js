import styled from "styled-components";

const Container = styled.div`
	width: 768px;
	padding: 15px 20px;
`;

const TitleContainer = styled.div`
	display: flex;
	margin-bottom: 20px;
	display: flex;
	align-items: center;
`;

const Back = styled.button`
	font-size: 30px;
	margin-right: 20px;
`;

const Title = styled.h2`
	font-size: 26px;
`;

const TableContainer = styled.div`
	display: flex;
	justify-content: space-between;
	width: 100%;
	height: 85%;
`;

const STable = styled.table`
	width: 48%;
	height: 90%;
`;

const SCaption = styled.caption`
	font-size: 24px;
	line-height: 30px;
	height: 30px;
	color: #2d2d2d;
	background: #37f734;
`;

const STr = styled.tr`
	height: 50px;
	line-height: 50px;
	border-bottom: 3px solid #37f734;
	font-size: 18px;
`;

const STd = styled.td`
	text-align: center;
	font-size: 18px;
	padding-top: 15px;
`;

export { Container, TitleContainer, Back, Title, TableContainer, STable, SCaption, STr, STd };
