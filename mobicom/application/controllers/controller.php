<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Controller extends CI_Controller {

	public function __construct(){

		parent::__construct();

	}

	public function home(){

		$this->load->view('home_view');

	}

}

?>