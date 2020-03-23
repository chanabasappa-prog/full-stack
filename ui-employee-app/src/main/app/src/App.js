import React, { Component } from 'react';
import logo from './logo.svg';
import Cookies from 'js-cookie';
import './App.css';
import { Button } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import ListGroup from 'react-bootstrap/ListGroup';


class App extends Component {
  constructor(props) {
    super(props);
    this.logout = this.logout.bind(this);
    this.state = {
      isLoaded: true,
      token: Cookies.get('access_token_cookie'),
      projectDetails: []
    }
  }

  logout() {
    console.log("herer")
    Cookies.remove('access_token_cookie');
    this.setState({ token: null });

  }
  componentDidMount() {
    if (this.state.token != null) {
      fetch("http://localhost:9191/projectdetails", {
        headers: new Headers({
          'Authorization': 'Bearer ' + this.state.token
        }),
      })
        .then(res => res.json())
        .then(
          (result) => {
            console.log(result)
            this.setState({
              isLoaded: true,
              projectDetails: result
            });
          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
            this.setState({
              isLoaded: true,
              error
            });
          }
        )
    }

  }

  render() {
    return <div className="App">
      
      
        
      
        
        

<Container>
  <Row>
    <Col>{this.state.token ? (
          <p>Logged In Already</p>
        ) : (
            <p><a
              className="App-link"
              href="securedPage"
              target="_self"
              rel="noopener noreferrer"
            >
              Login
        </a></p>
          )}</Col>
    <Col>{this.state.token ? (<a href="#" className="App-link" onClick={this.logout}>Logout</a>) : (<p></p>)}</Col>
  </Row>
  <Row>
    <Col>1 of 3</Col>
    <Col>{this.state.token ? (
          <ListGroup>
            {this.state.projectDetails.map(item => (
              <ListGroup.Item key={item.name}>
                {item.name}
              </ListGroup.Item>
            ))}
          </ListGroup>
        ) : (<p></p>)}</Col>
    <Col>3 of 3</Col>
  </Row>
</Container>
    </div>
  }
}

export default App
