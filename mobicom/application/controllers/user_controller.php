<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class User_Controller extends CI_Controller {

    public function __construct(){

        parent::__construct();
        $this->load->library('ion_auth');
        $this->load->model('user_model');

    }

    public function login(){

        $this->ion_auth->login($this->input->post('username'), $this->input->post('password'), false);

        if(true == $this->ion_auth->logged_in()){

            $user = $this->ion_auth->user()->row();
            $info['first name'] = $user->first_name;
            $info['last name'] = $user->last_name;
            $data['data'] = json_encode($info);

        }else {

            $data['data'] = "";

        }

        $this->load->view('login_view', $data);

    }

    public function logout(){

        $this->ion_auth->logout();
        $this->load->view('logout_view');
        $this->load->view('home_view');

    }

    public function register(){

        $valid_register = true;

        $username = $this->input->post('username');
        $password = $this->input->post('password');
        $confirm_password = $this->input->post('confirm_password');
        $email = $this->input->post('email');
        $additional_data = array(

            'first_name' => $this->input->post('first_name'),
            'last_name' => $this->input->post('last_name'),

        );

        $group = array('2');

        //$tables = $this->config->item('tables','ion_auth');

        $result['username'] = 'valid';
        $result['password'] = 'valid';
        $result['email'] = 'valid';

        if(true == $this->ion_auth->username_check($username) || true == strlen($username)<=5){

            $valid_register = false;
            $result['username'] = 'invalid';

        }

        if(0 != strcmp($confirm_password,$password) || false == preg_match_all('$\S*(?=\S{8,20})\S*$', $password)){

            $valid_register = false;
            $result['password'] = 'invalid';

        }

        $this->load->helper('email');

        if(true == $this->ion_auth->email_check($email) || false == valid_email($email)){

            $valid_register = false;
            $result['email'] = 'invalid';

        }

        if(true == $valid_register){

            $unique_id = uniqid();

            while($this->user_model->get_profile_unique_id($unique_id) != ''){

                $unique_id = uniqid();

            }

            $additional_data['unique_id'] = $unique_id;

            if(true == $this->ion_auth->register($username, $password, $email, $additional_data, $group)){

                $data['data'] = 'success';

            }else{

                $data['data'] = 'something went wrong';

            }

        }else {

            $data['data'] = json_encode($result);

        }

        $this->load->view('register_view', $data);

    }

    public function search_profile_unique_id(){

        $unique_id = $this->input->post('unique id');

        if(true == $this->ion_auth->logged_in()){

            $data['data'] = $this->user_model->get_profile_unique_id($unique_id);

        }else{

            $data['data'] = '';

        }

        $this->load->view('events_view', $data);

    }

}

?>