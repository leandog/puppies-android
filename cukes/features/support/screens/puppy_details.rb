class PuppyDetails
  include Gametel

  text(:name, :id => 'name')

  def active?
    platform.wait_for_activity "PuppyTaleActivity"
    platform.last_json
  end
  
end
