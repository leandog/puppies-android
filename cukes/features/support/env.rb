
require 'rspec-expectations'

require 'gametel'
require 'require_all'

require_rel 'screens'

World(Gametel::Navigation)

keystore = {
  :path => File.expand_path('debug.keystore'),
  :alias => 'androiddebugkey',
  :password => 'android',
  :keystore_password => 'android'
}

server = Brazenhead::Server.new('../app/bin/puppies_app-debug.apk', keystore)

class Driver
  include Brazenhead
end

Before do
  @driver = Driver.new
  server.start('PuppiesActivity')
end

After do
  server.stop
end

