'''
Created on 12 Apr 2017

@author: yang
'''
import unittest
import requests
import json
class Test(unittest.TestCase):


    def setUp(self):
        response = requests.get('http://api.github.com/users/Saberfans')
        json_obj = json.loads(response.content)
        json_str = json.dumps(json_obj, indent=4, separators=(',', ': '), sort_keys=True)
        print json_str

    def tearDown(self):
        pass


    def testName(self):
        pass


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()