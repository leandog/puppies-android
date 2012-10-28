class PuppyDetails
  include Gametel

  text(:name, :id => 'name')
  text(:breed, :id => 'breed')
  text(:gender, :id => 'gender')

  def active?
    platform.wait_for_activity "PuppyTaleActivity"
    platform.last_json
  end

end
